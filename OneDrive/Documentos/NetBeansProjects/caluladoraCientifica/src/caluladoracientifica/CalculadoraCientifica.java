package caluladoracientifica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
public class CalculadoraCientifica extends JFrame{
    //Declarar los componentes
    private JTextField display;
    private final JPanel panelBotones;
    private JButton Btn0,Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9,
                    BtnPunto, BtnE, BtnAns,BtnIgual,BtnSuma,BtnResta,
                    BtnMultiplicar,BtnDividir,BtnDel,BtnClear,btnRaiz,
                    BtnPercent,BtnLeftP,BtnRightP,btnExp,btnSin,BtnCos,
                    BtnTan, BtnRaiz3, BtnLog,BtnLn,BtnFactorial,BtnCeil,
                    BtnFloor,BtnTrunc;
    
    public CalculadoraCientifica(){
        //configuracion JFrame
        setTitle("Calculadora");
        setSize(450, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout( new BorderLayout(10,10));
        
        // Crear Componentes
   
        display = new JTextField(); // Pa mostrar la operacion actual y el resultado
        display.setBounds(20, 20, 250, 50);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(7, 5, 5, 5)); 
        JButton[] Buttons = inicializarBotones();
        for(JButton Boton : Buttons){
            Boton.setFont(new Font("Arial", Font.PLAIN, 18));
            Boton.addActionListener(new OperacionListener());
            panelBotones.add(Boton);
        }
       
        //añadir componentes
        add(display,BorderLayout.NORTH);
        add(panelBotones,BorderLayout.CENTER);
        
        // Acción de los botones especiales
        BtnIgual.addActionListener(e -> calcularResultado());
        BtnClear.addActionListener(e -> display.setText(""));
        BtnDel.addActionListener(e -> {
            String textoActual = display.getText();
            if (!textoActual.isEmpty()) {
                display.setText(textoActual.substring(0, textoActual.length() - 1));
            }
        });

    }
    // Clase interna para manejar los eventos de los botones
    private class OperacionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String texto = source.getText();
            // Validar que no se agreguen botones especiales al display
            String[] botonesEspeciales = {"=", "C", "DEL", "AC", "Ans","Trunc", "F"};
            if (! Arrays.asList(botonesEspeciales).contains(texto)) {
            display.setText(display.getText() + texto);
            }
        }
    }
    
    // Metodo para crear los botones
    private JButton[] inicializarBotones(){
        Btn0 = new JButton("0");
        Btn1 = new JButton("1");
        Btn2 = new JButton("2");
        Btn3 = new JButton("3");
        Btn4 = new JButton("4");
        Btn5 = new JButton("5");
        Btn6 = new JButton("6");
        Btn7 = new JButton("7");
        Btn8 = new JButton("8");
        Btn9 = new JButton("9");
        BtnPunto = new JButton(".");
        BtnE = new JButton("E");
        BtnAns = new JButton("Ans");
        BtnIgual = new JButton("=");
        BtnSuma = new JButton("+");
        BtnResta = new JButton("-");
        BtnMultiplicar = new JButton("*");
        BtnDividir = new JButton("/");
        BtnDel = new JButton("DEL");
        BtnClear = new JButton("AC");
        btnRaiz = new JButton("√");
        BtnPercent = new JButton("%");
        BtnLeftP = new JButton("(");
        BtnRightP = new JButton(")");
        btnExp = new JButton("^");
        btnSin = new JButton("sin(");
        BtnCos = new JButton("cos(");
        BtnTan = new JButton("tan(");
        BtnRaiz3 = new JButton("3√");
        BtnLog = new JButton("log(");
        BtnLn = new JButton("ln(");
        BtnFactorial = new JButton("!");
        BtnCeil = new JButton("C");
        BtnFloor = new JButton("F");
        BtnTrunc = new JButton("Trunc");
        
        JButton [] botones = new JButton[] {
            BtnLn, BtnFactorial, BtnCeil,BtnFloor,BtnTrunc, 
           btnSin, BtnCos, BtnTan, BtnRaiz3, BtnLog,
            btnRaiz, BtnPercent, BtnLeftP, BtnRightP, btnExp,
            Btn7, Btn8, Btn9, BtnDel, BtnClear,
            Btn4, Btn5, Btn6, BtnMultiplicar, BtnDividir,
            Btn1, Btn2, Btn3, BtnSuma, BtnResta,
            Btn0, BtnPunto, BtnE, BtnAns, BtnIgual,
            
        };
        
        return botones;
    }
    
    private void calcularResultado(){
        try
         {
        String expresion = display.getText();

        // Detectar si es ln(x)
        if (expresion.startsWith("ln(") && expresion.endsWith(")")) {
            String numeroStr = expresion.substring(3, expresion.length() - 1); // Extrae el número
            double numero = Double.parseDouble(numeroStr);
            double resultado = CalculadoraLogica.calcularLn(numero); // Llama a la otra clase
            display.setText(String.valueOf(resultado));
            return;
        }
        //ln

        // otras op

        } catch (Exception e) {
        display.setText("Error");
        }
        
        JOptionPane.showMessageDialog(null, "Se calculo el resultado");
        // enviar resultado al display
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            CalculadoraCientifica calc = new CalculadoraCientifica();
            calc.setVisible(true);
        });
        
    }
}
