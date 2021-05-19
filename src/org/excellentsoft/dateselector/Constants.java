/*
 * The MIT License
 *
 * Copyright (c) 2018-2021 ExcellentSoft.net
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.excellentsoft.dateselector;

import java.awt.Color;

/*
* CREATED 28/03/2018 | UPLOAD 19/05/2021
* AUTHOR J ADRIAN S. | EXCELLENTSOFT
* ALL RIGHT RESERVED
*  LICENSE GPL
* @DJASCDEV
* @EXCELLENTSOFT
* WWW.EXCELLENTSOFT.NET
 */
public class Constants {
    public static final int BUTTON_PREVIUS_YEAR = 0;
    public static final int BUTTON_PREVIUS_MONTH = 1;
    public static final int BUTTON_NEXT_YEAR = 2;
    public static final int BUTTON_NEXT_MONTH = 3;
    
    
    public static final int THEME_ID_WHITE = 10;
    public static final int THEME_ID_DEFAULT = 11;
    public static final int THEME_ID_RED = 12;
    public static final int THEME_ID_BLUE = 13;
    
    public static final int THEME_COUNT_CLIC_SELECT = 1;
    
    public static final Color[] THEME_WHITE ={
        new Color(238,238,238), //colorBackground,
        new Color(13,71,161), //colorFontDays,
        new Color(69,90,100), //colorFontNumbers
        new Color(96,125,139), //colorFontNumbersDisabled
        new Color(176,190,197), //colorBackgoundNumbersHover
        Color.white, //colorFontNumbersSelect
        new Color(21,101,192), //colorBackgroundNumbersSelect
        new Color(55,71,79) //colorFontApplyHover
    };
    public static final Color[] THEME_DEFAULT = {
            new Color(38,50,56), //colorBackground,
            new Color(240,240,240), //colorFontDays,
            new Color(210,200,215), //colorFontNumbers
            new Color(96,125,139), //colorFontNumbersDisabled
            new Color(69,90,100), //colorBackgoundNumbersHover
            Color.white, //colorFontNumbersSelect
            new Color(30,136,229), //colorBackgroundNumbersSelect
            new Color(230,230,230) //colorFontApplyHover
        };
    public static final Color[] THEME_RED = {
            new Color(198,40,40), //colorBackground,
            new Color(240,240,240), //colorFontDays,
            new Color(255,205,210), //colorFontNumbers
            new Color(229,115,115), //colorFontNumbersDisabled
            new Color(229,115,115), //colorBackgoundNumbersHover
            new Color(198,40,40), //colorFontNumbersSelect
            new Color(255,255,255), //colorBackgroundNumbersSelect
            new Color(239,154,154) //colorFontApplyHover
    };
    
    public static final Color[] THEME_BLUE = {
            new Color(30,136,229), //colorBackground,
            new Color(240,240,240), //colorFontDays,
            new Color(225,245,254), //colorFontNumbers
            new Color(79,195,247), //colorFontNumbersDisabled
            new Color(41,182,246), //colorBackgoundNumbersHover
            new Color(30,136,229), //colorFontNumbersSelect
            new Color(255,255,255), //colorBackgroundNumbersSelect
            new Color(179,229,252) //colorFontApplyHover
    };
}
