# Datetime-selector-java
DateTimeSelector is a public project created by excellentsoft for the community, it allows two Graphic Options: 
- Date Picker. 
- Date and Time Selector (TimeStamp)

DateTimeSelector es un projecto publico creado por excellentsoft para la comunidad, permite dos Opciones Gráficas: 
- Seleccionador de Fecha (Date).
- Seleccionador de Fecha y Hora (TimeStamp)

# How to install
  
  Download Binaries (.jar) (v1.0.0) => []

# How to use it

 ```Java
 //If you want the date to be selected with one click 
 com.djasc.dateselector.Constants.THEME_COUNT_CLIC_SELECT = 1;
 
 //If you want the date to be selected with double click 
 // com.djasc.dateselector.Constants.THEME_COUNT_CLIC_SELECT = 2;
 
 DateSelector dateSelector1 = new com.djasc.dateselector.DateSelector();
 DateTimeSelector dateTimeSelector1 = new com.djasc.dateselector.DateTimeSelector();
 
 //If you want to change the default theme set Theme_default Colors with A constant
 //Constants.THEME_ID_DEFAULT | Constants.THEME_ID_WHITE | Constants.THEME_ID_RED | Constants.THEME_ID_BLUE
 //dateSelector1.setLectThemesDefault(com.djasc.dateselector.Constants.THEME_NAME)
 
 JOptionPane.showMessageDialog(this, "Select Date IS: "+dateSelector1.getSelectDate());
 System.out.println(dateSelector1.getSelectedDate());
 
 JOptionPane.showMessageDialog(this, "Select TimeStamp IS: "+dateTimeSelector1.getSelectDate());
 System.out.println(dateTimeSelector1.getSelectedDate());
 
```

# Version
  - v0.0.0 [master](https://github.com/excellentsoft-org/datetime-selector-java)
  - v1.0.0 [tag v1.0.0](https://github.com/excellentsoft-org/datetime-selector-java)

# Next Features 
Version |    Date    | Notes
------- | ---------- | -------
-v1.0.0 | 2021-05-19 | Support TimeStamp

# Collaborators
 @djasc
 
# License

 The MIT License
 
 Copyright (c) 2018-2021 ExcellentSoft.net
 
  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:
 
  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.
 
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.


 

