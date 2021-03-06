/* DynamicAtom.java
 * =========================================================================
 * This file is part of the JLaTeXMath Library - http://forge.scilab.org/jlatexmath
 * 
 * Copyright (C) 2010 DENIZET Calixte
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * A copy of the GNU General Public License can be found in the file
 * LICENSE.txt provided with the source distribution of this program (see
 * the META-INF directory in the source jar). This license can also be
 * found on the GNU website at http://www.gnu.org/licenses/gpl.html.
 * 
 * If you did not receive a copy of the GNU General Public License along
 * with this program, contact the lead developer, or write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 * 
 */

package jlatexmath.dynamic;

import jlatexmath.Atom;
import jlatexmath.Box;
import jlatexmath.StrutBox;
import jlatexmath.TeXEnvironment;
import jlatexmath.TeXFormula;

/**
 * This kind of atom is used to have a dynamic content
 * which comes from an other soft such as ggb.
 * The goal is to avoid the reparsing (and the reatomization)
 * of the expression. 
 */
public class DynamicAtom extends Atom {
    
    private static ExternalConverterFactory ecFactory;
    private ExternalConverter converter;
    private TeXFormula formula = new TeXFormula();
    private String externalCode;
    
    public DynamicAtom(String externalCode) {
	this.externalCode = externalCode;
	if (ecFactory != null) {
	    this.converter = ecFactory.getExternalConverter();
	}
    }

    public static boolean hasAnExternalConverterFactory() {
	return ecFactory != null;
    }

    public static void setExternalConverterFactory(ExternalConverterFactory factory) {
	ecFactory = factory;
    }

    public Box createBox(TeXEnvironment env) {
	if (converter != null) {
	    formula.setLaTeX(converter.getLaTeXString(externalCode));
	    return formula.root.createBox(env);
	}
	return new StrutBox(0, 0, 0, 0);
    }
}