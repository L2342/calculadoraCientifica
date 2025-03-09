package caluladoracientifica;

public class CalculadoraLogica {

        // TODO code application logic here
        public static double sumar(double a,double b){
            return a+b;
        }
        public static double restar(double a, double b){
            return a-b;
        }
        public static double dividir(double a, double b){
            return a/b;
        }
        public static double multiplicar(double a, double b){
            return a*b;
        }
        public static double calcularLn(double x) {
            
            return Math.log(x); //ln base e
        }
        public static double calcularLog(double x) {
            
            return Math.log10(x); // log base 10
        }
        
        public static double calcularSin(double x) {
            
            return Math.sin(x); // seno solo en radianes
        }
        
        public static double calcularCos(double x) {
            
            return Math.cos(x); // coseno solo en radianes
        }
        
        public static double calcularTan(double x) {
            
            return Math.tan(x); // tangente solo en radianes
        }
}
