package caluladoracientifica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculadoraCientifica extends JFrame{
    //Declarar los componentes
    private JTextField display;
    private JPanel panelBotones;
    private JButton Btn0,Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9,
                    BtnPunto, BtnE, BtnAns,BtnIgual,BtnSuma,BtnResta,
                    BtnMultiplicar,BtnDividir,BtnDel,BtnClear,btnRaiz,
                    BtnPercent,BtnLeftP,BtnRightP,btnExp,btnSin,BtnCos,
                    BtnTan, BtnRaiz3, BtnLog,BtnLn,BtnFactorial;
    
    public CalculadoraCientifica(){
        //configuracion JFrame
        setTitle("Calculadora");
        setSize(400, 600);
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
        panelBotones.setLayout(new GridLayout(6, 5, 5, 5)); 
        JButton[] Buttons = inicializarBotones();
        for(JButton Boton : Buttons){
            Boton.setFont(new Font("Arial", Font.PLAIN, 18));
            panelBotones.add(Boton);
        }
        
        
        
        //añadir componentes
        add(display,BorderLayout.NORTH);
        add(panelBotones,BorderLayout.CENTER);
        
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
        BtnClear = new JButton("C");
        btnRaiz = new JButton("√");
        BtnPercent = new JButton("%");
        BtnLeftP = new JButton("(");
        BtnRightP = new JButton(")");
        btnExp = new JButton("^");
        btnSin = new JButton("sin");
        BtnCos = new JButton("cos");
        BtnTan = new JButton("tan");
        BtnRaiz3 = new JButton("∛");
        BtnLog = new JButton("log");
        BtnLn = new JButton("ln");
        BtnFactorial = new JButton("!");
        
        JButton [] botones = new JButton[] {
        Btn0, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9,
        BtnPunto, BtnE, BtnAns, BtnIgual, BtnSuma, BtnResta,
        BtnMultiplicar, BtnDividir, BtnDel, BtnClear, btnRaiz,
        BtnPercent, BtnLeftP, BtnRightP, btnExp, btnSin, BtnCos,
        BtnTan, BtnRaiz3, BtnLog, BtnLn, BtnFactorial
        };
        
        return botones;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            CalculadoraCientifica calc = new CalculadoraCientifica();
            calc.setVisible(true);
        });
        
    }
}
