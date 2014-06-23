import java.math.*;
import java.util.ArrayList;
/**
 *
 * @author sureshraja
 */
class compgen
{
   
    public boolean compare(key k1, key k2,int accuracy)
    {
        if(k1.symX.size()==k2.symX.size()&&k1.symY.size()==k2.symY.size())
        {
            for (int i=0;i<k1.symX.size();i++)
            {
                if((char)k1.symX.toArray()[i]!=(char)k2.symX.toArray()[i])
                {
                    return false;
                }
            
            }
            for (int i=0;i<k1.symY.size();i++)
            {
                if((char)k1.symY.toArray()[i]!=(char)k2.symY.toArray()[i])
                {
                    return false;
                }
            
            }
            for (int i=0;i<k1.percx.size();i++)
            {
                if(Math.abs((int)k1.percx.toArray()[i]-(int)k2.percx.toArray()[i])>accuracy)
                {
                    return false;
                }
            
            }
            for (int i=0;i<k1.percy.size();i++)
            {
                if(Math.abs((int)k1.percy.toArray()[i]-(int)k2.percy.toArray()[i])>accuracy)
                {
                    return false;
                }
            
            }
            //
        }
        else
        {
            return false;
        }
        return true;
    }
  public key generate(ArrayList x,ArrayList y)
  {
      key k=new key();
      char last; int prev=-1;int c=1;char s;
      if((int)x.toArray()[0] >= (int)x.toArray()[1])
      {
          
          last='d';
      }
      else if((int)x.toArray()[0] < (int)x.toArray()[1])
      {
          last='u';
      }
      else 
      {
          int i;
                    for(i=1;i<x.size();i++)
                    {if(x.toArray()[i-1]!=x.toArray()[i])break;}
          if((int)x.toArray()[0]>(int)x.toArray()[i])
              last='d';
          else
              last='u';
      }
      
      s=last;
      for (Object temp:x)
      {
          
          int a=(int)temp;
          if(prev==-1)
          {
              prev=a;
          }
          else if(prev>a)
          {
              if(last!='d')
              {
                  k.symX.add(last);
                  k.numX.add(c);
                  c=2;s='d';
              }
              else
              {
                  s='d';
                  c++;
              }
          }
          else if(prev<a)
          {
              if(last!='u')
              {
                  k.symX.add(last);
                  k.numX.add(c);
                  c=2;s='u';
              }
              else
              {
                  s='u';
                  c++;
              }
              
          }
          else if(prev==a)
          {
              c++;
              
          } 
          last=s;
      }
      k.symX.add(last);
                  k.numX.add(c);
                  
                  
                  
                  
                  
      
      
       prev=-1; c=1;char sym;
      if((int)y.toArray()[0] > (int)y.toArray()[1])
      {
         
          last='d';
      }
      else if((int)y.toArray()[0] < (int)y.toArray()[1])
      {
         
          last='u';
      }
      else
      {
          int i;
          for(i=1;i<y.size();i++)
              if(y.toArray()[i-1]!=y.toArray()[i])break;
          if((int)y.toArray()[0]>(int)y.toArray()[i])
              last='d';
          else
              last='u';
              
      }
      
      sym=last;
      for (Object temp:y)
      {
          
          int a=(int)temp;
          if(prev==-1)
          {
              prev=a;
          }
          else if(prev>a)
          {
              if(last!='d')
              {
                  k.symY.add(last);
                  k.numY.add(c);
                  c=2;sym='d';
                  
              }
              else
              {
                  sym='d';
                  c++;
              }
          }
          else if(prev<a)
          {
              if(last!='u')
              {
                  k.symY.add(last);
                  k.numY.add(c);
                  c=2;sym='u';
              }
              else
              {
                  sym='u';
                  c++;
              }
              
          }
         else if(prev==a)
          {
              c++;
              
          } 
           last=sym;
      } 
      k.symY.add(last);
                  k.numY.add(c);
      
                  
                  
                  
                  
                  int sumx=0,sumy=0;
                  for(Object a:k.numX)
                  sumx=sumx+(int)a;
                  for(Object a:k.numY)
                  sumy=sumy+(int)a;
                  
                  for(int i=0;i<k.numX.size();i++)
                      k.percx.add(((int)k.numX.toArray()[i]/sumx)*100);
                
                  for(int i=0;i<k.numY.size();i++)
                      k.percy.add(((int)k.numY.toArray()[i]/sumy)*100);

                  
                  
                  
                  
                  
      return k;
  }
};




class key
{
    public ArrayList symX;
    public ArrayList symY;
    public ArrayList numX;
    public ArrayList numY;
    public ArrayList percx;
     public ArrayList percy;
    public key()
    {
        percx = new ArrayList();
        percy = new ArrayList();
     symX = new ArrayList();
     symY= new ArrayList();
     numX = new ArrayList();
     numY= new ArrayList();
    }
    public String toString()
    {
        return (symX.toString()+symY.toString()+numX.toString()+numY.toString());
    }
};

public class NewJFrame extends javax.swing.JFrame {

    
    public ArrayList X;
    public ArrayList Y;
    public int previousx;
    public int previousy;
    public int currentx;
    public int currenty;
    public key one;
    public key two;
    int flag;
     
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
       X = new ArrayList();
     Y= new ArrayList();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        textField2 = new java.awt.TextField();
        textField3 = new java.awt.TextField();
        textField4 = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mousemovedonform(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        textField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField1.setEditable(false);
        textField1.setEnabled(false);
        textField1.setText("textField1");
        textField1.setVisible(false);
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        textField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField2.setEditable(false);
        textField2.setEnabled(false);
        textField2.setText("textField2");
        textField2.setVisible(false);
        textField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField2ActionPerformed(evt);
            }
        });

        textField3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField3.setEditable(false);
        textField3.setEnabled(false);
        textField3.setText("textField3");
        textField3.setVisible(false);

        textField4.setEditable(false);
        textField4.setEnabled(false);
        textField4.setText("result");

        jLabel2.setText("Use enter and space. first read Readme.txt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mousemovedonform(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousemovedonform
        // TODO add your handling code here:
    
    }//GEN-LAST:event_mousemovedonform

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        
        if(textField3.getText().toString().equals("10")){
            currentx=evt.getXOnScreen();
            currenty=evt.getYOnScreen();
            if(Math.abs(previousx-currentx)==20)
            {
                    
                    X.add(previousx);
                    Y.add(previousy);
                    previousx=currentx;
                    previousy=currenty;
            }
            else
            {
                    X.add(currentx);
                    Y.add(currenty);
                    previousx=currentx;
                    previousy=currenty;
            }
    
        }
        
    }//GEN-LAST:event_formMouseMoved

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_formMousePressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       textField3.setText(evt.getKeyCode()+"");
        if(evt.getKeyCode()==32&&flag==0)
        {
          textField1.setText(X.toString());        
          textField2.setText(Y.toString()); 
          compgen c = new compgen();
          one=c.generate(X, Y);
          textField3.setText(one.toString());
          flag=1;
          X = new ArrayList();
          Y= new ArrayList();
          
        }
        
        
        
        if(evt.getKeyCode()==32&&flag==1)
        {
         
          ////
          
          ////
          compgen c = new compgen();
          textField1.setText(X.toString());        
          textField2.setText(Y.toString()); 
          two=c.generate(X, Y);
          textField3.setText(two.toString());
          if(c.compare(one, two, 10))
          {
              textField4.setText("matched pattern");
          }
          else
              textField4.setText("unmatched pattern");
        }
        
       
        
    }//GEN-LAST:event_formKeyPressed

private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField2ActionPerformed
 // TODO add your handling code here:
}//GEN-LAST:event_textField2ActionPerformed

private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
 // TODO add your handling code here:
}//GEN-LAST:event_textField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    // End of variables declaration//GEN-END:variables
}
