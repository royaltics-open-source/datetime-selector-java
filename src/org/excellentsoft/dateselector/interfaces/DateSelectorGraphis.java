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
/*
* CREATED 28/03/2018 | UPLOAD 19/05/2021
* AUTHOR J ADRIAN S. | EXCELLENTSOFT
* ALL RIGHT RESERVED
*  LICENSE GPL
* @DJASCDEV
* @EXCELLENTSOFT
* WWW.EXCELLENTSOFT.NET
 */
package org.excellentsoft.dateselector.interfaces;

/**
 *
 * @author Djasc Dev
 */
import org.excellentsoft.dateselector.Constants;
import static org.excellentsoft.dateselector.Constants.THEME_COUNT_CLIC_SELECT;
import org.excellentsoft.dateselector.DateSelector;
import org.excellentsoft.dateselector.DateTimeSelector;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public final class DateSelectorGraphis
{
    private final Calendar cal = Calendar.getInstance();
    private int indexSelect = 0;
    private int endFill = 0;
    private int month = Calendar.getInstance().get(java.util.Calendar.MONTH);
    private int year = Calendar.getInstance().get(java.util.Calendar.YEAR);
    private final SimpleDateFormat formatShow = new SimpleDateFormat("MMM   yyyy"); 
    private SimpleDateFormat formatParse = new SimpleDateFormat("dd/MM/yyyy");
    private String day = null;
    private JFrame d;
    private JLabel[] button = new JLabel[49];
    private final JLabel monthCurrent = new JLabel("", JLabel.CENTER);
    private final String[] header = { "D", "L", "M", "M", "J", "V", "S" };
    private JPanel context;
    private Color[] theme_default = {
        new Color(38,50,56), //colorBackground,
        new Color(240,240,240), //colorFontDays,
        new Color(210,200,215), //colorFontNumbers
        new Color(96,125,139), //colorFontNumbersDisabled
        new Color(69,90,100), //colorBackgoundNumbersHover
        Color.white, //colorFontNumbersSelect
        new Color(30,136,229), //colorBackgroundNumbersSelect
        new Color(230,230,230) //colorFontApplyHover
    };
    
    public DateSelectorGraphis(JPanel context, Component parent, int x_, int y, int width, int height, Color[] theme)//create constructor 
    {
        this.context = context;
        if(this.theme_default.length < 8 ){
            JOptionPane.showMessageDialog(parent, "Error, Tema no Compatible con DjascSelectorDate.\n Aplicando Theme por Defecto");
        }else this.theme_default = theme;
        d = new JFrame();
        SwingUtilities.updateComponentTreeUI(d);
        d.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        d.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        d.setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        d.setResizable(false);
        d.setUndecorated(true);
        d.setType(javax.swing.JFrame.Type.UTILITY);
        d.setLocation(x_,y+height - 2);
        d.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                d.dispose();
            }
        });
        JPanel p1 = new JPanel(new GridLayout(7, 6));
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel(new GridLayout(1, 1));
        p1.setBackground(theme_default[0]);
        p1.setPreferredSize(new Dimension(width, 200));
        p3.setBackground(theme_default[0]);
        p2.setLayout(new GridBagLayout());
        p2.setBackground(theme_default[0]);
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel pYear = new JLabel(" << ", JLabel.CENTER);
        pYear.setToolTipText("Año Anterior");
        JLabel pMonth = new JLabel(" < ", JLabel.CENTER);
        pMonth.setToolTipText("Mes Anterior");
        JLabel nMonth = new JLabel(" > ", JLabel.CENTER);
        nMonth.setToolTipText("Siguiente Mes");
        JLabel nYear = new JLabel(" >> ", JLabel.CENTER);
        nYear.setToolTipText("Siguiente Año");
        monthCurrent.setPreferredSize(new Dimension(90, 32));
        pYear = generateButonCustom(pYear, Constants.BUTTON_PREVIUS_YEAR);
        pMonth = generateButonCustom(pMonth, Constants.BUTTON_PREVIUS_MONTH);
        nMonth = generateButonCustom(nMonth, Constants.BUTTON_NEXT_MONTH);
        nYear = generateButonCustom(nYear, Constants.BUTTON_NEXT_YEAR);
        gbc.gridx = 0;
        gbc.insets = new Insets(7, 0, 7, 0);
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        p2.add(pYear, gbc);
        gbc.gridx = 1;
        p2.add(pMonth, gbc);
        gbc.gridx = 2;
        gbc.gridwidth = 5;
        p2.add(monthCurrent,gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 7;
        p2.add(nMonth, gbc);
        gbc.gridx = 8;
        p2.add(nYear, gbc);
        //-----------
        JLabel apply = new JLabel("By DjascDev        SELECCIONAR", JLabel.CENTER);
        apply.setForeground(theme_default[6]);
        apply.setPreferredSize(new Dimension(90, 32));
        apply.setFont(new java.awt.Font("Dialog", 1, 10));
        apply.setCursor(new Cursor(Cursor.HAND_CURSOR));
        apply.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        apply.setForeground(theme_default[7]);
                    }
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        apply.setForeground(theme_default[6]);
                    }
                    @Override
                    public void mouseClicked (MouseEvent e){
                        if(indexSelect>7){
                            day = button[indexSelect].getText();
                            if(indexSelect >= endFill)
                                month++;
                            displayDate();
                            returnDate(e);
                            d.dispose();
                        }
                    }
                });
        p3.add(apply, BorderLayout.CENTER);
        
        for (int x = 0; x < button.length; x++){ 
            final int selection = x;
            button[x] = new JLabel();
            button[x].setHorizontalAlignment(JLabel.CENTER);
            button[x].setBorder(null);
            button[x].setOpaque(true);
            button[x].setCursor(new Cursor(Cursor.HAND_CURSOR));
            button[x].setSize(new Dimension(20,20));
            button[x].setPreferredSize(new Dimension(20,20));
            button[x].setBackground(theme_default[0]);
            button[x].setForeground(theme_default[2]);
            if (x > 6)
                button[x].setFont(new java.awt.Font("Dialog", 1, 12));
            button[x].addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        if(selection < endFill && indexSelect != selection)
                            button[selection].setBackground(theme_default[4]);
                    }
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        if(indexSelect != selection ){
                            button[selection].setBackground(theme_default[0]);
                            button[selection].setForeground(theme_default[2]);
                        }
                        if(indexSelect != selection && selection >= endFill)
                            button[selection].setForeground(theme_default[3]);
                    }
                    @Override
                    public void mouseClicked (MouseEvent e){
                        if(!button[selection].getText().trim().isEmpty()){
                            if(e.getClickCount() == THEME_COUNT_CLIC_SELECT) {
                                day = button[selection].getText();
                                if(!isNumeric(day)) return;
                                if(selection >= endFill)
                                    month++;
                                displayDate();
                                returnDate(e);
                                d.dispose();
                                e.consume();
                            }else if(e.getClickCount() == 1){
                                indexSelect = selection;
                                repaintDefault(false);
                                button[indexSelect].setForeground(theme_default[5]);
                                button[indexSelect].setBackground(theme_default[6]);
                            }
                        }
                    }

                
                });
            if (x < 7){
                button[x].setText(header[x]);
                button[x].setForeground(theme_default[1]);
            }
            p1.add(button[x]);
        }

        d.add(p2, BorderLayout.NORTH);
        d.add(p1, BorderLayout.CENTER);
        d.add(p3, BorderLayout.SOUTH);
        d.pack();
        displayDate();
        d.setVisible(true);
    }
    
    public void setMonth(int year, int month){
        this.year = year;
        this.month = month;
    }
    
    public void show(int x, int y, int height){
        d.setLocation(x,y+height - 2);
        d.setVisible(true);
    }

    public void displayDate() 
    {
       // Calendar now = Calendar.getInstance();
       // boolean current = this.year == now.get(Calendar.YEAR) && this.month == now.get(Calendar.MONTH);
        for (int x = 7; x < button.length; x++)
            button[x].setText("");
        cal.set(year, month, 1); 
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        int day_;
        for (endFill = 6 + dayOfWeek,  day_ = 1; day_ <= daysInMonth; endFill++, day_++){
            button[endFill].setText("" + day_);
        }
        for(int j=endFill, d = 1;  j< 49; j++, d++){
            button[j].setText("" + d);
            button[j].setForeground(theme_default[3]);
        }
        repaintDefault(true);
        monthCurrent.setForeground(theme_default[1]);
        monthCurrent.setText(formatShow.format(cal.getTime()).toUpperCase());
    }

    public void setPickedDate(SimpleDateFormat format){
        this.formatParse = format;
       /* if (day == null)
           return day;
        cal.set(year, month, Integer.parseInt(day));
        return formatParse.format(cal.getTime());*/
    }

    private void returnDate(MouseEvent evt) {
        try{
            cal.set(year, month, Integer.parseInt(day));
            if(this.context instanceof DateSelector)
                ((DateSelector) this.context).returnData(formatParse.format(cal.getTime()));
            else if(this.context instanceof DateTimeSelector){
                ((DateTimeSelector) this.context).returnData(formatParse.format(cal.getTime()));
            }
        }catch(Exception ex){
            if(this.context instanceof DateSelector)
               ((DateSelector) this.context).returnData(null);
            else if(this.context instanceof DateTimeSelector){
                 ((DateTimeSelector) this.context).returnData(null);
            }
        }
    }
    
    private JLabel generateButonCustom(JLabel button, int type_button) {
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(25, 32));
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(null);
        button.setFont(new java.awt.Font("Dialog", 1, 11));
        button.setBackground(theme_default[0]);
        button.setForeground(theme_default[1]);
        button.addMouseListener(new MouseAdapter(){
             @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        button.setForeground(theme_default[0]);
                        button.setBackground(theme_default[1]);
                    }
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        button.setForeground(theme_default[1]);
                        button.setBackground(theme_default[0]);
                    }
            @Override
            public void mouseClicked (MouseEvent e){
                if(type_button == Constants.BUTTON_NEXT_YEAR)
                    year++;
                else if(type_button == Constants.BUTTON_NEXT_MONTH)
                    month++;
                else if(type_button == Constants.BUTTON_PREVIUS_MONTH)
                    month--;
                else if(type_button == Constants.BUTTON_PREVIUS_YEAR)
                    year--;

                displayDate();
            }
        });
        return button;
    }
    
    private void repaintDefault(boolean currentDay) {
        Calendar now = Calendar.getInstance();
        boolean active_day = false;
        boolean current = this.year == now.get(Calendar.YEAR) && this.month == now.get(Calendar.MONTH) ;
        for (int x = 7; x < button.length; x++){
            button[x].setBackground(theme_default[0]);
            if(!button[x].getText().isEmpty() && current && !active_day && now.get(Calendar.DAY_OF_MONTH) == Integer.parseInt(button[x].getText())){
                button[x].setForeground(theme_default[5]);
                button[x].setBackground(theme_default[4]);
                if(currentDay)  indexSelect = x;
                active_day = true;
            }else{
                if(x>=endFill)
                    button[x].setForeground(theme_default[3]);
                else
                    button[x].setForeground(theme_default[2]);
            }
        }
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
 