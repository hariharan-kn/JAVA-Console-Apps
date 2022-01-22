import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class UserAccount{
    String pin;
    String name;
    int bal;
    ArrayList<String> tr = new ArrayList<>();
    public static ArrayList<String> withdraw(int a,int[] b){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Scanner sc = new Scanner(System.in);
        ArrayList <String> ans = new ArrayList<>();
        System.out.println("Enter Withdraw Amount : ");
        int wa = sc.nextInt();
        int va =wa;
        int ha = va;
        int[] val = new int[]{100,200,500,2000};
        if(wa<=a){
        if(wa<=b[4]){
            if((a>=wa)&&(wa%100==0)){
                Boolean x =false;
                for(int i=0;i<4;i++){
                    if(wa/val[val.length-1-i]<=b[b.length-2-i]){
                        wa-=wa/val[val.length-1-i]*val[val.length-1-i];
                    }
                    else{
                        wa-=val[val.length-1-i]*b[b.length-1-i];
                    }
                }
                int[] thearray = new int[4];
            if(wa==0){
                for(int i=0;i<4;i++){
                    if(va/val[val.length-1-i]<=b[b.length-2-i]){
                        thearray[i]=va/val[val.length-1-i];
                        va-=va/val[val.length-1-i]*val[val.length-1-i];
                    }
                    else{
                        va-=val[val.length-1-i]*b[b.length-1-i];
                        thearray[i]=va/val[val.length-1-i];
                    }
                }
                for(int opo=0;opo<4;opo++){
                    ans.add(Integer.toString(thearray[thearray.length-opo-1]));
                }
                a-=ha;
                System.out.println("Amount Withdrawed Successfully");
                ans.add(Integer.toString(ha));
                ans.add("WithDrawed = "+Integer.toString(wa)+":Avail. Balance = "+Integer.toString(a) +" at "+formattedDate);
                return ans;
            }
            else{
                ans.add(null);
                return ans;
            }
            }
            else{
                System.out.println("Invalid Amount,Enter In 100's !!");
                ans.add(null);
                ans.add(null);
                return ans;
            }
    }
    else{
        System.out.println("Insufficient ATM Balance");
        ans.add(null);
        ans.add(null);
        return ans;
    }
}else{
    System.out.println("Insufficient Balance");
    ans.add(null);
    ans.add(null);
    return ans;
}
    }
    public static ArrayList<String> deposit(int a){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Scanner sc = new Scanner(System.in);
        int[] y = new int[4];
        System.out.println("Enter Deposit Amount : ");
        int da = sc.nextInt();
        System.out.println("Enter number of 100's : ");
        y[0] = sc.nextInt();
        System.out.println("Enter number of 200's : ");
        y[1] = sc.nextInt();
        System.out.println("Enter number of 500's : ");
        y[2] = sc.nextInt();
        System.out.println("Enter number of 2000's : ");
        y[3] = sc.nextInt();
        ArrayList<String> ans = new ArrayList<>(); 
        if(y[0]*100+y[1]*200+y[2]*500+y[3]*2000==da){
        if((100<=da)&&(da%100==0)){
        a+=da;
        System.out.println("Amount Deposited Successfully");
        ans.add(Integer.toString(da));
        ans.add("Deposited Amount = "+Integer.toString(da)+";Avail.Balance = "+Integer.toString(a)+" at "+formattedDate);
        ans.add(Integer.toString(y[0]));
        ans.add(Integer.toString(y[1]));
        ans.add(Integer.toString(y[2]));
        ans.add(Integer.toString(y[3]));
        return ans;
        }
        else{
            System.out.println("Invalid Amount,Enter In 100's !!");
            ans.add(null);
            ans.add(null);
            return ans;
        }
    }
    else{
        System.out.println("Entered amount doesnot match your denomination amount");
        ans.add(null);
        return ans;
    }
    }
    public static ArrayList<String> AmountTransfer(ArrayList<UserAccount> x ,int from,int to){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        ArrayList<String> ans  = new ArrayList<>();
        System.out.println("Enter amount To transfer : ");
        Scanner sc = new Scanner(System.in);
        int amt = sc.nextInt();
        if((amt>0)&&(amt<x.get(from).bal)){
            System.out.println("Amount Transfered Successfully");
            ans.add(Integer.toString(amt));
            ans.add(Integer.toString(amt)+"Transfered to "+x.get(to).name+" : "+"Avail. Balance = "+Integer.toString(x.get(from).bal-amt)+"at"+formattedDate);
            ans.add(Integer.toString(amt)+"Transfered from "+x.get(from).name+" : "+"Avail. Balance = "+Integer.toString(amt+x.get(to).bal)+" at "+formattedDate);
            return ans;
        }
        else{
            ans.add("-1");
            return ans;
        }
    }
    
}
class Admin{
    String name;
    String pin;
    public static int[] deposit(){
        int[] ans = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Deposit Amount : ");
        int da = sc.nextInt();
        System.out.println("Enter number of 100's : ");
        ans[0] = sc.nextInt();
        System.out.println("Enter number of 200's : ");
        ans[1] = sc.nextInt();
        System.out.println("Enter number of 500's : ");
        ans[2] = sc.nextInt();
        System.out.println("Enter number of 2000's : ");
        ans[3] = sc.nextInt();
        if(ans[0]*100+ans[1]*200+ans[2]*500+ans[3]*2000==da){
            if((100<=da)&&(da%100==0)){
                System.out.println("Amount Deposited Successfully");
                ans[4]=da;
            return ans;
            }
            else{
            System.out.println("Enter Valid Amount..");
            ans[0]=-1;
            return ans;
        }
        }
        else{
            System.out.println("Denominations doesnot match your money deposited");
            ans[0]=-1;
        return ans;
        }
    }
}
public class Main{
    public static String changepin(String x){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entered current PIN : ");
        String y =sc.nextLine();
        if(x.equals(y)){
            System.out.println("Enter Your new Password : ");
            String m1 = sc.next();
            System.out.println("Re-Enter Your new Password : ");
            String m2 = sc.next();
            if(m1.equals(m2)){
                System.out.println("PIN change Successful");
                return m1;
            }
            else{
                System.out.println("Entered Password Doesnot match");
                return null;
            }
        }
        else{
            System.out.println("Incorrect Password");
            return null;
        }
        
    }
public static ArrayList<Integer> valid_user(ArrayList<UserAccount> x ){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println("Enter Name :");
        String c = sc.next();
        System.out.println("Enter PIN :");
        String d = sc.next();
        for(int i=0;i<x.size();i++){
            if((x.get(i).name.equals(c))&&(x.get(i).pin.equals(d))){
                ans.add(i);
            }
        }
        if(ans.size()!=0){
            return ans;    
        }
        else{
            ans.add(-1);
            return ans;
        }
    }
public static ArrayList<Integer> valid_admin(ArrayList<Admin> x ){
            Scanner sc = new Scanner(System.in);
            ArrayList<Integer> ans = new ArrayList<>();
            System.out.println("Enter Name :");
            String c = sc.next();
            System.out.println("Enter PIN :");
            String d = sc.next();
            for(int i=0;i<x.size();i++){
                if((x.get(i).name.equals(c))&&(x.get(i).pin.equals(d))){
                    ans.add(i);
                }
            }
            if(ans.size()!=0){
                return ans;    
            }
            else{
                ans.add(-1);
                return ans;
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        UserAccount a2 = new UserAccount();
        UserAccount a1 = new UserAccount();
        UserAccount a3 = new UserAccount();
        ArrayList<UserAccount> users = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();
        int[] atm = new int[]{10,10,6,2,10000};
        Admin b1 = new Admin();
        Admin b2 = new Admin();
        Admin b3 = new Admin();
        a1.bal = 500;
        a1.pin = "1111";
        a1.name = "user1";
        a2.bal = 700;
        a2.pin = "2222";
        a2.name = "user2";
        a3.bal = 1000;
        a3.pin = "3333";
        a3.name = "user3";
        b1.pin = "1111";
        b1.name = "admin1";
        b2.pin = "1112";
        b2.name = "admin2";
        b3.pin = "1113";
        b3.name = "admin3";
        int atmbal = 10000;
        users.add(a1);
        users.add(a2);
        users.add(a3);
        admins.add(b1);
        admins.add(b2);
        admins.add(b3);
        Boolean whole_exit = false;
        while(!whole_exit){
            System.out.println("Enter Your Choice : ");
            System.out.println("1-User");
            System.out.println("2-Admin");
            System.out.println("3-Exit");
            int x = sc.nextInt();
            switch(x){
                case 1:int i = valid_user(users).get(0);
                if(i!=-1){
                Boolean exit_status_users=false;
                while(!exit_status_users){
                    System.out.println("1-withdraw");
                    System.out.println("2-deposit");
                    System.out.println("3-Check Balance");
                    System.out.println("4-Amount Transfer");
                    System.out.println("5-Mini Statement");
                    System.out.println("6-Change Pin");
                    System.out.println("7-LogOut");
                    System.out.println("Enter Your Choice: ");
                    int ch = sc.nextInt();
                    switch(ch){
                        case 1:ArrayList<String> z =users.get(i).withdraw(users.get(i).bal,atm);
                        if(z.get(0)!=null){
                        users.get(i).bal-=Integer.parseInt(z.get(4));
                        atm[4]-=Integer.parseInt(z.get(4));
                        users.get(i).tr.add(z.get(5));
                        for(int d=0;d<4;d++){
                            atm[d]-=Integer.parseInt(z.get(d));
                        }
                        }
                        else{
                            System.out.println("Insufficient Denominations");
                        }
                        break;
                        case 2:ArrayList<String> y=users.get(i).deposit(users.get(i).bal);
                        if(y.get(0)!=null){
                        users.get(i).bal+=Integer.parseInt(y.get(0));
                        atm[4]+=Integer.parseInt(y.get(0));
                        users.get(i).tr.add(y.get(1));
                        for(int v=0;v<4;v++){
                            atm[v]+=Integer.parseInt(y.get(v+2));
                        }
                    }
                        break;
                        case 3:System.out.println("Your Balance is "+users.get(i).bal);
                        break;
                        case 4:System.out.println("Choose the person You want to transfer amount : ");
                                for(int k=0;k<users.size();k++){
                                    if(k!=i){
                                        System.out.println(k+"-"+users.get(k).name);
                                    }
                                }
                                int val = sc.nextInt();
                                if((val!=i)&&(val<users.size())&&(val>=0)){
                                ArrayList<String> at =users.get(i).AmountTransfer(users,i,val);
                                if(at.get(0)!="-1"){ 
                                users.get(i).bal-=Integer.parseInt(at.get(0));
                                users.get(val).bal+=Integer.parseInt(at.get(0));
                                users.get(i).tr.add(at.get(1));
                                users.get(val).tr.add(at.get(2));
                                    }
                                    else{
                                        System.out.println("Enter a Valid Amount");
                                    }
                                }
                                else{
                                    System.out.println("Enter a valid User ");
                                }
                                break;
                        case 7:exit_status_users = true;
                        break;
                        case 5:System.out.println(users.get(i).tr);
                        break;
                        case 6:String stts = changepin(users.get(i).pin);
                        if(stts!=null){
                            users.get(i).pin=stts;
                        }
                        break;
                        default:System.out.println("Invalid Choice");
                    }
                }
            }
            else{
                System.out.println("Entered Credentials doesnot Match");
            }
                break;
                case 2:int j = valid_admin(admins).get(0);
                if(j!=-1){
                Boolean exit_status_admin=false;
                while(!exit_status_admin){
                    System.out.println("1-deposit");
                    System.out.println("2-Check Balance");
                    System.out.println("3-Change PIN");
                    System.out.println("4-LogOut");
                    System.out.println("Enter Your Choice: ");
                    int ch = sc.nextInt();
                    switch(ch){
                        case 1:int[] n = admins.get(j).deposit();
                        if(n[0]!=-1){
                            for(int v=0;v<5;v++){
                                atm[v]+=n[v];
                            }
                        }
                        break;
                        case 2:System.out.println("ATM Balance is "+atm[4]);
                        System.out.println("Available 100's "+atm[0]);
                        System.out.println("Available 200's "+atm[1]);
                        System.out.println("Available 500's "+atm[2]);
                        System.out.println("Available 2000's "+atm[3]);
                        break;
                        case 3:String sts = changepin(admins.get(j).pin);
                        if(sts!=null){
                            admins.get(j).pin=sts;
                        }
                        break;
                        case 4:exit_status_admin = true;
                        break;
                        default:System.out.println("Invalid Choice");
                    }
                }
            }
            else{
                System.out.println("Entered Credentials doesnot Match");
            }
                break;
                case 3:whole_exit=true;
                break;
                default:System.out.println("Invalid Choice");
            }
        }
        System.out.println("Thanking you for banking with us");
        }
}
