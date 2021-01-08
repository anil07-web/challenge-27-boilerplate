import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;
public class Challenge27 {
    public static void main(String[] args) {
    Scanner obj = new Scanner(System.in);
    Scanner obj1 = new Scanner(System.in);
    char ch;
    int n=0;
    String agecategory;
    long accno = 1111111111110l;
    Savingbankacc[] object = new Savingbankacc[100];
    System.out.println("Enter today date(dd/mm/yyyy)");
    int x = obj.nextInt();
    System.out.print("/");
    int y = obj.nextInt();
    System.out.print("/");
    int z = obj.nextInt();
    LocalDateTime d1 = LocalDateTime.of(z,y,x,0,0);
		do{
        System.out.println("Enter the First name of customer");
        String a=obj.next();
        System.out.println("Enter the Last name of customer");
        String b=obj.next();
        System.out.println("Enter the Age of customer");
        int c=obj.nextInt();
        agecategory = Savingbankacc.categorizedCitizen(c);
        System.out.println("Enter the Aadhaar id of customer");
        String d=obj.next();
        System.out.println("Enter the Address of customer");
        String e=obj1.nextLine();
        System.out.println("Enter the Balance of customer which he/she wants to deposit");
        int bal=obj.nextInt();
        int k=0;
        do{ 
        System.out.println("Enter the Phone number of customer");
        long f=obj.nextLong();   
        if(Savingbankacc.count(f)==10){
        System.out.println("Enter the Village of customer"); 
        String g=obj.next();
        System.out.println("Your Account Number is : "+(++accno));
        object[n] = new Savingbankacc(a,b,c,d,e,f,g,bal,agecategory);
        k=0;
        }
        else{
        System.out.println("Please enter 10 digits number only\n");
        k=1;
        }
        }while(k==1);
        n++;
        System.out.println("Do you want to Add Customer (y/n)");
        ch = obj.next().charAt(0);
        }while( ch == 'y' || ch =='Y');
        System.out.println("\nPlease ! Enter your 13 digits Account Number ");
        int m1=1;
        int y22=0;
        int z222=0;
        int k=1;
        do{
          long x22=obj.nextLong();
          for(int i=0;i<n;i++){
          if(x22==object[i].getAccno()){
          y22=i;
          m1=0;
          }
          }
         if(m1==1)
         {
         System.out.println("Please ! Enter a correct Acc. No. :");
         }
         }while(m1==1);
        System.out.println("Enter today date(dd/mm/yyyy)");
        int x1 = obj.nextInt();
        System.out.print("/");
        int y1 = obj.nextInt();
        System.out.print("/");
        int z1 = obj.nextInt();
        LocalDateTime d2 = LocalDateTime.of(z1,y1,x1,0,0);
        long diff = Duration.between(d1, d2).toDays();
        float p=Savingbankacc.interest(diff, object[y22].getagecategory(), object[y22].getBalance());
        object[y22].setBalance(p);
        do{
        System.out.println("\nPress 1: Check the balance\nPress 2: Withdrawal of money\nPress 3: Deposit of money\nPress 4: funds transfer from one account to another\nPress 5: Exit ");
        int choice = obj.nextInt();
        switch (choice){
            case 1: if(diff>365){
                    System.out.println("This is Dormant account and a fresh customer KYC needs to be done :"); 
                    break;
                    }
                    else{
                    System.out.println("The current balance is :"+object[y22].getBalance());
                    break;
                    }
            case 2: if(diff>365){
                    System.out.println("This is Dormant account and a fresh customer KYC needs to be done :"); 
                    break;
                    }
                    else{
                    System.out.println("Enter withdrawl money :");
                    float z2 = obj.nextInt();
                    float c1 =Savingbankacc.withdrwal( object[y22].getBalance(), z2) ;
                    object[y22].setBalance(c1);
                    System.out.println("Withdrwal Successfully !");
                    break;
                    }
            case 3: if(diff>365){
                    System.out.println("This is Dormant account and a fresh customer KYC needs to be done :"); 
                    break;
                    }
                    else{
                    System.out.println("Enter deposit money :");
                    float z22 = obj.nextInt();
                    float d11 = Savingbankacc.deposit( object[y22].getBalance(), z22) ;
                    object[y22].setBalance(d11);
                    System.out.println("Deposit Successfully !");
                    break;
                    }
            case 4: if(diff>365){
                    System.out.println("This is Dormant account and a fresh customer KYC needs to be done :"); 
                    break;
                    }
                    else{
                    System.out.println("Enter Account Number in which transfer the fund");
                    long a11 = obj.nextLong();
                    int j=1;
                    for(int i=0;i<n;i++){
                        if(a11==object[i].getAccno()){
                          z222=i;
                           j=0;
                        }
                    }
                    if(j==1){
                    System.err.println(" Account number is wrong, the operation  immediately abort");
                    break;
                    }
                    System.out.println("Enter the amount :");
                    float a111 = obj.nextFloat();
                    float g11 = Savingbankacc.fundTransfer( a111 ,object[z222].getBalance());
                    object[z222].setBalance(g11);
                    object[y22].setBalance(object[y22].getBalance()-a111);
                    System.out.println("Fund Transfer Successfully !");
                    }
                   break;
            case 5: k=0;
                   break;
                  }        
            }while( k!=0);
        }
}

 class Savingbankacc {
    private String firstname;
    private String lastname;
    private int age;
    private String aadhaar;
    private String address;
    private long phno;
    private  static int id=0;
    private  static  long Acno=1111111111110l;
    private  long Accno;
    private  float Balance;
    private String agecategory;
    private int customerid;
    private String village;
    Scanner sc = new Scanner(System.in);
    public Savingbankacc(String fname,String lname,int age,String aadhaar,String address,long phno,String vill,float Bal,String agecategory ){
      id++;
      Acno++;
      this.customerid=id;
      this.firstname=fname;
      this.lastname=lname;
      this.age=age;
      this.aadhaar=aadhaar;
      this.address=address;
      this.phno=phno;
      this.village=vill;
      this.Balance=Bal;
      this.Accno= Acno;
      this.agecategory=agecategory;
    }
    public  void setBalance(float bal){
        this.Balance = bal;
    }
    public String getfname(){
      return firstname;
    }
    public String getlname(){
     return lastname;
    }
    public int getage(){
     return age;
    }
    public String getaadhar(){
     return aadhaar;
    }
    public String getaddress(){
     return address;
    }
    public long getphno(){
     return phno;
    }
    public int getid(){
     return customerid;
    }
    public String getvillage(){
     return village;
    }
    public float getBalance(){
    return Balance;
    } 
    public long getAccno(){
    return Accno;
    }
    public String getagecategory(){
    return agecategory;
    }
    public static String categorizedCitizen (int age) {
     if(age<=14){
      return "Minor";
     }
     else if(age>14 && age<60){
      return "Public_Person";
     }
     else{ 
      return"Senior_citizen";
     }
     }
    public static long count(long n) {
      if(n==0)
      return 0;
      return 1+count(n/10);
    }
    public static float interest(long diff , String agecategory ,float Bal) {
      
       if(agecategory.equals( "Minor"))
       return Bal+(10*Bal*diff)/(365*100);
       else if(agecategory.equals("Public_Person"))
       return Bal+(12*Bal*diff)/(365*100);
       else 
       return Bal+(7*Bal*diff)/(365*100);
       
  
     }
    public static float withdrwal(float Bal,float z2){
      return Bal - z2;
     }
    public static float deposit(float Bala,float z22){
      return Bala+z22;
    }
    public static float fundTransfer(float fund ,float balance) {
      return balance + fund;
    }
}   

