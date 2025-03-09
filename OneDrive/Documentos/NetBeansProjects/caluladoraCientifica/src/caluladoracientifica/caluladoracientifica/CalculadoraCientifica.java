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
                    BtnFloor,BtnDeg, BtnRad, BtnMod;
    private double resultado = 0.0; //variable para ans
    
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
        panelBotones.setLayout(new GridLayout(8, 4, 5, 5)); 
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
            String[] botonesEspeciales = {"=", "DEL", "AC", "Ans"};
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
        BtnRaiz3 = new JButton("\u00B3√");
        BtnLog = new JButton("log(");
        BtnLn = new JButton("ln(");
        BtnFactorial = new JButton("!");
        BtnCeil = new JButton("Ceil(");
        BtnFloor = new JButton("Floor(");
        BtnDeg = new JButton("Deg(");
        BtnRad = new JButton("Rad(");
        BtnMod = new JButton("mod");
        
        JButton [] botones = new JButton[] {
            BtnLn, BtnFactorial, BtnCeil,BtnFloor,BtnDeg,
            BtnRad,btnSin, BtnCos, BtnTan, BtnRaiz3, 
            BtnLog,btnRaiz, BtnPercent, BtnLeftP, BtnRightP,
            Btn7, Btn8, Btn9, BtnDel, BtnClear,
            Btn4, Btn5, Btn6, BtnMultiplicar, BtnDividir,
            Btn1, Btn2, Btn3, BtnSuma, BtnResta,
            Btn0, BtnPunto, BtnE, BtnAns, BtnIgual,btnExp,BtnMod
            
        };
        
        return botones;
    }
    
    private void calcularResultado(){
        
        try
         {
            String expresion = display.getText();
            //1.  ln(x)
            if (expresion.startsWith("ln(") && expresion.endsWith(")")) {
                String numeroStr = expresion.substring(3, expresion.length() - 1); // Extrae el número
                double numero = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.calcularLn(numero); // Llama a la otra clase
                display.setText(String.valueOf(resultado));
            }
            //2.log
            else if (expresion.startsWith("log(") && expresion.endsWith(")")){
                String numeroStr = expresion.substring(4,expresion.length()-1);
                double numero = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.calcularLog(numero);
                display.setText(String.valueOf(resultado));            
            }
            //3. sin(x)
            else if (expresion.startsWith("sin(") && expresion.endsWith(")")){
                String numeroStr = expresion.substring(4,expresion.length()-1);
                double numero = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.calcularSin(numero);
                display.setText(String.valueOf(resultado));            
            }
            //4.cos
            else if (expresion.startsWith("cos(") && expresion.endsWith(")")){
                String numeroStr = expresion.substring(4,expresion.length()-1);
                double numero = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.calcularCos(numero);
                display.setText(String.valueOf(resultado));            
            }
            //5.tan
            else if (expresion.startsWith("tan(") && expresion.endsWith(")")){
                String numeroStr = expresion.substring(4,expresion.length()-1);
                double numero = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.calcularTan(numero);
                display.setText(String.valueOf(resultado));            
            }
            //6. ! (Factorial)
             else if (expresion.endsWith("!")){
                String numeroStr = expresion.substring(0,expresion.length()-1);
                int numero = Integer.parseInt(numeroStr);
                resultado = CalculadoraLogica.calcularFac(numero);
                display.setText(String.valueOf(resultado));            
            }
            //7. E (Exponente)
            else if (expresion.contains("E")){
                 String numeroStrb = expresion.substring(0,expresion.indexOf("E"));
                 String numeroStre = expresion.substring(expresion.indexOf("E")+1);
                 double numerob = Double.parseDouble(numeroStrb);
                 int numeroe = Integer.parseInt(numeroStre);
                 resultado = CalculadoraLogica.calcularNotacionC(numerob, numeroe);
                 display.setText(String.valueOf(resultado));
             }
            //8. suma
            else if (expresion.contains("+")) {
                String[] numeros = expresion.split("\\+"); 
                if (numeros.length == 2) {
                    double num1 = Double.parseDouble(numeros[0].trim());
                    double num2 = Double.parseDouble(numeros[1].trim());
                    resultado = CalculadoraLogica.sumar(num1, num2); 
                    display.setText(String.valueOf(resultado));
                }
            }
            //9. resta
            else if (expresion.contains("-")) {
                String[] numeros = expresion.split("-"); 
                if (numeros.length == 2) {
                    double num1 = Double.parseDouble(numeros[0].trim());
                    double num2 = Double.parseDouble(numeros[1].trim());
                    resultado = CalculadoraLogica.restar(num1, num2); 
                    display.setText(String.valueOf(resultado));
                }
            }
            // 10. division
            else if (expresion.contains("/")) {
                String[] numeros = expresion.split("/"); 
                if (numeros.length == 2) {
                    double num1 = Double.parseDouble(numeros[0].trim());
                    double num2 = Double.parseDouble(numeros[1].trim());
                    resultado = CalculadoraLogica.dividir(num1, num2); 
                    display.setText(String.valueOf(resultado));
                }
            }
            //11 .multiplicar
            else if (expresion.contains("*")) {
                String[] numeros = expresion.split("\\*"); 
                if (numeros.length == 2) {
                    double num1 = Double.parseDouble(numeros[0].trim());
                    double num2 = Double.parseDouble(numeros[1].trim());
                    resultado = CalculadoraLogica.multiplicar(num1, num2); 
                    display.setText(String.valueOf(resultado));
                }
            }
            //12. raiz
            else if (expresion.startsWith("√")){
                String numeroStr = expresion.substring(1);
                double numero = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.raiz(numero);
                display.setText(String.valueOf(resultado));            
            }
            // 13. Porcentaje %
            else if (expresion.endsWith("%")){
                 String numeroStr = expresion.substring(0,expresion.length()-1);
                 double numero = Double.parseDouble(numeroStr);
                 resultado = CalculadoraLogica.porcentaje(numero);
                 display.setText(String.valueOf(resultado ));
             }

            //14. potencia
            else if (expresion.contains("^")){
                String[] partes = expresion.split("\\^");
                double base = Double.parseDouble(partes[0]);
                double exponente = Double.parseDouble(partes[1]);
                resultado = CalculadoraLogica.potencia(base, exponente);
                display.setText(String.valueOf(resultado));   
            }
            //15.raiz3
            else if (expresion.startsWith("\u00B3")){
                 String numeroStr = expresion.substring(2,expresion.length());
                 double numero = Double.parseDouble(numeroStr);
                 resultado = CalculadoraLogica.calcularCuboR(numero);
                 display.setText(String.valueOf(resultado)); 
            }
            //16. Ceil(x)
            else if (expresion.startsWith("Ceil(") && expresion.endsWith(")")) {
                String numeroStr = expresion.substring(5, expresion.length() - 1);
                double numero = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.calcularCeil(numero);
                display.setText(String.valueOf(resultado));
            }
            // 17.Floor(x)
            else if (expresion.startsWith("Floor(") && expresion.endsWith(")")) {
                String numeroStr = expresion.substring(6, expresion.length() - 1);
                double numero = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.calcularFloor(numero);
                display.setText(String.valueOf(resultado));
            }
            // 18. Radianes a Grados
            else if (expresion.startsWith("Deg(") && expresion.endsWith(")")) {
            String numeroStr = expresion.substring(4, expresion.length() - 1);
            double radianes = Double.parseDouble(numeroStr);
            resultado = CalculadoraLogica.radianesAGrados(radianes);
            display.setText(String.valueOf(resultado));
            }
            // 19 Convertir grados a radianes
            else if (expresion.startsWith("Rad(") && expresion.endsWith(")")) {
                String numeroStr = expresion.substring(4, expresion.length() - 1);
                double grados = Double.parseDouble(numeroStr);
                resultado = CalculadoraLogica.gradosARadianes(grados);
                display.setText(String.valueOf(resultado));
            }
            // 20. Modulo
            else if (expresion.contains("mod")) {
                String[] numeros = expresion.split("mod"); 
                if (numeros.length == 2) {
                    double num1 = Double.parseDouble(numeros[0].trim());
                    double num2 = Double.parseDouble(numeros[1].trim());
                    resultado = CalculadoraLogica.modulo(num1,num2);
                    display.setText(String.valueOf(resultado));
                }
            }

        } catch (Exception e) {
                display.setText("Error");
        }
        BtnAns.addActionListener(e -> display.setText(display.getText() + resultado)); //hace que funcione ans
    }
   
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            CalculadoraCientifica calc = new CalculadoraCientifica();
            calc.setVisible(true);
        });
    }
}
