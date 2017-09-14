/*
Code by Carlos Ulloa
 */
package calcu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora extends JFrame {
    JPanel panelNumeros, panelOperaciones;
    JTextField pantalla;
    double resultado;
    boolean nuevaOperacion= true;
    
    public Calculadora(){
        super();
    setVisible (true);
    setResizable(true);
    setSize(500,500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Conversor");
    
    JPanel panel= (JPanel) this.getContentPane();
    pantalla= new JTextField();
    pantalla.setEditable(false);
    pantalla.setBackground(Color.WHITE);
    panel.add("North",pantalla);
    
    panelNumeros= new JPanel();
    for(int n=9; n>=0; n--){
    nuevoBotonNumerico("" + n);
    }
    nuevoBotonNumerico(".");
    panel.add("Center", panelNumeros);
    
    panelOperaciones= new JPanel();
    nuevoBotonOperaciones("Convertir");
     nuevoBotonOperaciones("Limpiar");
     panel.add("East", panelOperaciones);
    
    }

    private void nuevoBotonNumerico(String digito) {
        JButton btn= new JButton(digito);
        btn.setText(digito);
        btn.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseReleased(MouseEvent evt){
        JButton btn=(JButton) evt.getSource();
        numeroPulsado(btn.getText());
        }

            
        });
        panelNumeros.add(btn);
    }

    private void nuevoBotonOperaciones(String operacion) {
        JButton btn= new JButton(operacion);
        btn.setText(operacion);
        btn.addMouseListener(new MouseAdapter(){
       
            @Override
        public void mouseReleased(MouseEvent evt){
        JButton btn=(JButton) evt.getSource();
        operacionPulsada(btn.getText());
        }

           

            
        });
        panelOperaciones.add(btn);
    }
    
    private void numeroPulsado(String digito) {
if(pantalla.getText().equals("0")||nuevaOperacion){
pantalla.setText(digito);
}

else {
    pantalla.setText(pantalla.getText() + digito);
        }

nuevaOperacion= false;
    }
    
     private void operacionPulsada(String dato) {
         if(dato.equals("Convertir")){
         convertir();
         }
         else if(dato.equals("Limpiar")){
         cero();
            }}

     
    private void convertir() {
float re = Float.parseFloat(pantalla.getText());
float ra =(re / 17);
pantalla.setText(""+ ra);
    }

    private void cero() {
pantalla.setText("0");    
    }
}
