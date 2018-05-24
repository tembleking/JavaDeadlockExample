public class Deadlock { 
    Integer a = 0;
    Integer b = 1;
     
    Thread th1 = new Thread("Thread 1"){
        public void run(){
            while(true){
                synchronized(a){
                    synchronized(b){
                        System.out.printf("%d - %d\n", a, b);
                    }
                }
            }
        }
    };
     
    Thread th2 = new Thread("Thread 2"){
        public void run(){
            while(true){
                synchronized(b){
                    synchronized(a){
                        System.out.printf("%d - %d\n", b, a);
                    }
                }
            }
        }
    };

    Deadlock() {
	th1.start();
	th2.start();
    } 
     
    public static void main(String a[]){
        Deadlock dl = new Deadlock();
    }
}
