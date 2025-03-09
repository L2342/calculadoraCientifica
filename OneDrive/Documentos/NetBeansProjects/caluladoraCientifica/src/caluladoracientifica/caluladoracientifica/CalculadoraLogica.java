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
        public static double raiz(double x){
            return Math.sqrt(x);
        }
        public static double porcentaje(double x){
            return x/100;
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
        
        public static double potencia(double base, double exponente) {
            return Math.pow(base, exponente);
        }
        
        public static int calcularFac(int x) {
           int r = 0;
            
            for(int i=x-1; i>=1; i--){
                
                int y = x * (i);
                x = y;
                r = y;
          
            }

            return r;
        }
        public static double calcularCuboR(double x){
            return Math.cbrt(x);
        }
}
