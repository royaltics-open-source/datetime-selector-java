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
package org.excellentsoft.dateselector;

import org.excellentsoft.dateselector.interfaces.DateSelectorGraphis;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import static java.lang.Integer.parseInt;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Djasc World
 */
public class DateTimeSelector extends JPanel {
    private String selectDate;
    private SimpleDateFormat formatParse;
    private Component contex;
    private DateSelectorGraphis dateSelector;
    private Color[] theme_default;
    private boolean editable = true;
    
    /**
     * 
     * @param  formatParse in Format Date and Time Example: "dd/MM/yyyy HH:mm"
     */
    public DateTimeSelector(SimpleDateFormat formatParse) {
        initComponents();
        this.formatParse = formatParse;
        defaultStart();
    }
     
    public DateTimeSelector() {
        initComponents();
        formatParse = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        defaultStart();
    }


    private void defaultStart(){
        setLectThemesDefault(Constants.THEME_ID_DEFAULT);
        setEnabled();
        setFocusable();
    }
    
    public Color[] getTheme_default() {
        return theme_default;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        setEnabled();
    }

    public void setLectThemesDefault(int THEME_NAME) {
        switch (THEME_NAME) {
            case Constants.THEME_ID_WHITE:
                this.theme_default = Constants.THEME_WHITE;
                break;
            case Constants.THEME_ID_DEFAULT:
                this.theme_default = Constants.THEME_DEFAULT;
                break;
            case Constants.THEME_ID_RED:
                this.theme_default = Constants.THEME_RED;
                break;
            case Constants.THEME_ID_BLUE:
                this.theme_default = Constants.THEME_BLUE;
                break;
            default:
                break;
        }
    }
    
    public void setTheme_default(Color[] theme_default) {
        this.theme_default = theme_default;
    }

    public Component getContex() {
        return contex;
    }

    public void setContex(Component contex) {
        this.contex = contex;
    }
    
    public Timestamp getSelectedDate() {
        try {
            dateSelect.setBorder(new LineBorder(new Color(204,204,204), 1));
            selectDate = dateSelect.getText();
            formatParse.setLenient(false);
            Date date = formatParse.parse(selectDate+" "+jTime.getText());
            return new Timestamp(date.getTime());
        }catch (ParseException ex) {
            dateSelect.setBorder(new LineBorder(new Color(150,0,0), 1));
            clear();
            return null;
        }
    }
    
    public String getSelectDate() {
        return getSelectedDate() == null ?  null : dateSelect.getText().trim() +" "+jTime.getText().trim();
    }
    
    public String getSelectDateFormat() {
        return getSelectDateFormat(null) ;
    }
    
    public String getSelectDateFormat(SimpleDateFormat simpleFormat) {
        return simpleFormat == null ? formatParse.format(getSelectedDate()) : simpleFormat.format(getSelectedDate());
    }

    public void clear() {
        this.selectDate = null;
        dateSelect.setValue(null);
        jTime.setValue(null);
    }
    
    
   public void setDate(Date date) {
        if(date != null){
            setDate(new Timestamp(date.getTime()));
        }
    }
    
    public void setDate(Timestamp date) {
        String dateTime = date == null ? null : formatParse.format(date);
        if(dateTime != null){
            this.selectDate = dateTime.split(" ")[0];
            dateSelect.setText(this.selectDate);
            jTime.setText(dateTime.split(" ")[1]);
        }
    }
    

    /**
     * //TODO: Set TimeStamp
     * @param selectDate in Format getFormatParse() and 
     * @param selectTime in Format HH:mm
     */
    
    public void setDateTime(String selectDate, String selectTime) {
        if(selectDate!=null){
            this.selectDate = selectDate;
            dateSelect.setText(this.selectDate);
        }else{
            clear();
        }
        if(selectTime!=null){
            jTime.setText(selectTime);
        }else{
            clear();
        }
    }

    public SimpleDateFormat getFormatParse() {
        return formatParse;
    }

    public void setFormatParse(SimpleDateFormat formatParse) {
        this.formatParse = formatParse;
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateSelect = new javax.swing.JFormattedTextField();
        jIcon = new javax.swing.JLabel();
        jTime = new javax.swing.JFormattedTextField();

        setMinimumSize(new java.awt.Dimension(139, 20));
        setPreferredSize(new java.awt.Dimension(139, 20));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        dateSelect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        try {
            dateSelect.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dateSelect.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateSelect.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateSelectFocusLost(evt);
            }
        });
        dateSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateSelectActionPerformed(evt);
            }
        });
        dateSelect.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dateSelectKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateSelectKeyTyped(evt);
            }
        });
        add(dateSelect);

        jIcon.setBackground(new java.awt.Color(83, 83, 98));
        jIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/excellentsoft/resources/calendar.png"))); // NOI18N
        jIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jIcon.setFocusable(false);
        jIcon.setMaximumSize(new java.awt.Dimension(500, 2147483647));
        jIcon.setMinimumSize(new java.awt.Dimension(30, 18));
        jIcon.setOpaque(true);
        jIcon.setPreferredSize(new java.awt.Dimension(30, 18));
        jIcon.setRequestFocusEnabled(false);
        jIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jIconMouseClicked(evt);
            }
        });
        add(jIcon);

        jTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTime.setText("00:00");
        jTime.setMinimumSize(new java.awt.Dimension(5, 20));
        jTime.setPreferredSize(new java.awt.Dimension(5, 20));
        jTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTimeActionPerformed(evt);
            }
        });
        add(jTime);
    }// </editor-fold>//GEN-END:initComponents

    private void jIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIconMouseClicked
        if(!isEditable() || !isEnabled())
            return;
        Dimension size = this.getSize();
        Component root = this.contex == null ? this : this.contex;
        int xframe = 0;
        int yframe = 0;
        Component obj = root;
        do{
            obj = obj.getParent();
            if(obj!=null){
                xframe+=obj.getX();
                yframe+=obj.getY();
            }
        }while (obj != null);
        
        int x = xframe + root.getX();
        int y = yframe + root.getY();
        if(this.dateSelector == null){
            this.dateSelector = new DateSelectorGraphis(this,root,x-3,y+2,size.width,size.height, theme_default);
            this.dateSelector.setPickedDate(formatParse);
        }else{
            if(!dateSelect.getText().replace("/","").trim().isEmpty() && dateSelect.getText().contains("/")){
                String d[] = dateSelect.getText().split("/");
                this.dateSelector.setMonth(parseInt(d[2]),parseInt(d[1])-1);
                this.dateSelector.displayDate();
            }
            this.dateSelector.show(x-3,y+2,size.height);
        }
        dateSelect.setText(this.selectDate);
    }//GEN-LAST:event_jIconMouseClicked

    private void dateSelectFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateSelectFocusLost
        if(getSelectedDate()==null) {
            selectDate = null;
        }
    }//GEN-LAST:event_dateSelectFocusLost

    private void dateSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateSelectActionPerformed

    private void dateSelectKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateSelectKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(getSelectedDate()==null) {
                selectDate = null;
            }
        }
    }//GEN-LAST:event_dateSelectKeyPressed

    private void dateSelectKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateSelectKeyTyped
        /*char car = evt.getKeyChar();
        boolean writer = true;
        if(dateSelect.getText().length()>=10){ 
            writer = dateSelect.getSelectedText() != null && dateSelect.getSelectedText().length()>0;
        }
        if((car<'0' || car>'9') && car!='/') writer = false;
        if(!writer)
            evt.consume();*/
      
    }//GEN-LAST:event_dateSelectKeyTyped

    private void jTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTimeActionPerformed
    
    public void returnData(String date){
        this.selectDate = date;
        dateSelect.setText(this.selectDate);
        this.jTime.requestFocus();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dateSelect;
    private javax.swing.JLabel jIcon;
    private javax.swing.JFormattedTextField jTime;
    // End of variables declaration//GEN-END:variables

    private void setEnabled() {
        dateSelect.setEnabled(isEnabled());
        dateSelect.setEditable(isEditable());
        jIcon.setEnabled(isEditable());
        jIcon.setEnabled(isEnabled());
        jTime.setEditable(isEditable());
        jTime.setEnabled(isEditable());
        dateSelect.repaint();
        jTime.repaint();
        jIcon.repaint();
        repaint();
    }
    
    private void setFocusable() {
        dateSelect.setFocusable(isFocusable());
        jTime.setFocusable(isFocusable());
        //jLabel1.setFocusable(isFocusable());
        dateSelect.repaint();
        jTime.repaint();
       // jLabel1.repaint();
        repaint();
    }
}
