import java.util.*;
class Train{
    int id;
    int amt;
    String name;
    int seats;
    int stations;
    int[][] arr = new int[stations][seats];
}
class Ticket{
    int  train;
    ArrayList<Integer> seatno = new ArrayList<>();
    int from;
    int to;
    int amt;
}
class User{
    String name;
    String pin;
    int wallet=1000;
    ArrayList<Ticket> Booked = new ArrayList<>();
}
class Admin{
    String name;
    String pin;
}
class Main{
    public static ArrayList<Integer> edittrain(ArrayList<Train> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<x.size();i++){
            System.out.println("Train Id : "+x.get(i).id);
            System.out.println("Train name : "+x.get(i).name);
            System.out.println("------------------------");
        }
        System.out.println("Choose The Train You Want To Edit : ");
        int id = sc.nextInt();
        System.out.println("1-Ticket Amount");
        System.out.println("2-Number Of Seats");
        System.out.println("3-Number Of Stations");
        System.out.println("Enter The Field You Want To Enter (1-3) : ");
        int fie = sc.nextInt();
        System.out.println("Enter the value You want It to be Edited : ");
        int val = sc.nextInt();
        int ind = -1;
        for(int i=0;i<x.size();i++){
            if(x.get(i).id==id){
                ind = i; 
            }
        }
        res.add(ind);
        if(ind!=-1){
            res.add(fie);
            res.add(val);
        }
        return res;
    }
    public static int removetrain(ArrayList<Train> x){
        Scanner sc = new Scanner(System.in);
        int res = -1;
        for(int i=0;i<x.size();i++){
            System.out.println("Train ID : "+x.get(i).id);
            System.out.println("Train Name : "+x.get(i).name);
            System.out.println("---------------------------");
        }
        System.out.println("Enter the Train ID : ");
        int rid = sc.nextInt();
        for(int i=0;i<x.size();i++){
            if(x.get(i).id==rid){
                res=i;
            }
        }
        return res;
    }
    public static Train addtrain(ArrayList<Train> x){
        Scanner sc = new Scanner(System.in);
        Train t = new Train();
        System.out.println("Enter Train Name : ");
        t.name = sc.nextLine();
        System.out.println("Enter Train Id : ");
        int id = sc.nextInt();
        System.out.println("Enter Ticket rate : ");
        int trate = sc.nextInt();
        System.out.println("Enter Number Of Stations : ");
        int stat = sc.nextInt();
        System.out.println("Enter Number Of Seats : ");
        int seats = sc.nextInt();
        Boolean b = true;
        for(int i=0;i<x.size();i++){
            if(x.get(i).id==id){
                b=false;
            }
        }
        if(b&&(stat>1)&&(trate>50)&&(seats>1)){
            int[][] a = new int[stat][seats];
            t.id = id;
            t.amt = trate;
            t.seats = seats;
            t.stations = stat;
            t.arr = a;
        }
        else{
            t.id=-1;
        }

        return t;
        
    }
    public static int valid_admin(ArrayList<Admin> x){
        Scanner sc = new Scanner(System.in);
        int res = -1;
        System.out.println("Enter Your Name : ");
        String name = sc.next();
        System.out.println("Enter Your PIN : ");
        String pin = sc.next();
        for(int i=0;i<x.size();i++){
            if(x.get(i).name.equals(name)&&x.get(i).pin.equals(pin)){
                res=i;
            }
        }
        return res;
    }
    public static int valid_user(ArrayList<User> x){
        Scanner sc = new Scanner(System.in);
        int res = -1;
        System.out.println("Enter Your Name : ");
        String name = sc.next();
        System.out.println("Enter Your PIN : ");
        String pin = sc.next();
        for(int i=0;i<x.size();i++){
            if(x.get(i).name.equals(name)&&x.get(i).pin.equals(pin)){
                res=i;
            }
        }
        return res;
    }
    public static User reg_user(ArrayList<User> x){
        Scanner sc = new Scanner(System.in);
        User y = new User();
        y.wallet=0;
        System.out.println("Enter Your username : ");
        String name = sc.nextLine();
        System.out.println("Enter Your PIN : ");
        String pin = sc.nextLine();
        for(int i=0;i<x.size();i++){
            if(x.get(i).name==name){
                y.wallet = -1;
            }
        }
        y.name = name;
        y.pin = pin;
        return y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Train> trains = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();
        Train t1 = new Train();
        t1.id = 1;
        t1.amt = 45;
        t1.name = "Chennai Exp.";
        t1.stations = 5; 
        t1.seats  =10;
        int[][] a = new int[t1.stations][t1.seats];
        t1.arr = a;
        User u1 = new User();
        u1.name = "u1";
        u1.pin = "u1u1";
        u1.wallet = 1000;
        Admin a1 = new Admin();
        a1.name = "a1";
        a1.pin = "a1a1";
        trains.add(t1);
        users.add(u1);
        admins.add(a1);
        Boolean whole_exit=false;
        while(!whole_exit){
            System.out.println("1-Admin");
            System.out.println("2-User");
            System.out.println("3-Exit");
            int ch = sc.nextInt();
            switch(ch){
                case 1:int al = valid_admin(admins);
                if(al!=-1){
                    Boolean admin_exit = false;
                    while(!admin_exit){
                        System.out.println("1-Add Trains");
                        System.out.println("2-Remove Trains");
                        System.out.println("3-Edit Train");
                        System.out.println("4-View Trains and Availability");
                        System.out.println("5-Exit");
                        int ach = sc.nextInt();
                        switch(ach){
                            case 1:Train t = addtrain(trains);
                            if(t.id!=-1){
                                trains.add(t);
                                System.out.println("Train Added Successfully");
                            }
                            else{
                                System.out.println("Entered details are not valid");
                            }
                            break;
                            case 2:int rt = removetrain(trains);
                            if(rt!=-1){
                                trains.remove(rt);
                                System.out.println("Train Removed Successfully");
                            }else{
                            System.out.println("Enter Valid ID");
                            }
                            break;
                            case 3:ArrayList<Integer> et = edittrain(trains);
                            if(et.get(0)!=-1){
                                switch(et.get(1)){
                                    case 1:if(et.get(2)>50){
                                        trains.get(et.get(0)).amt = et.get(2);
                                    }
                                    else{
                                        System.out.println("Invalid Ticket Price");
                                    }
                                        break;
                                    case 2:if(et.get(2)>1){
                                        trains.get(et.get(0)).seats = et.get(2);
                                    }else{
                                        System.out.println("Invalid Number of seats");
                                    }
                                        break;
                                    case 3:if(et.get(2)>1){
                                        trains.get(et.get(0)).stations = et.get(2);
                                    }else{
                                        System.out.println("Invalid Number of stations");
                                    }
                                        break;
                                }
                                int[][] x = new int[trains.get(et.get(0)).stations][trains.get(et.get(0)).seats];
                                trains.get(et.get(0)).arr = x;
                            }
                            else{
                                System.out.println("Invalid ID");}
                            break;
                            case 4:for(int i=0;i<trains.size();i++){
                                System.out.println(trains.get(i).name);
                                for(int j=0;j<trains.get(i).arr.length;j++){
                                    for(int k=0;k<trains.get(i).arr[0].length;k++){
                                        System.out.print(trains.get(i).arr[j][k]);
                                    }
                                    System.out.println();
                                }
                            }
                            break;
                            case 5:admin_exit =true;
                            break;
                            default:System.out.println("Enter a valid option : ");
                        }
                    }
                }
                else{
                    System.out.println("Entered Credentials Doesnot Match");
                }
                break;
                case 2:System.out.println("1-New User");
                System.out.println("2-Existing User");
                int ur = sc.nextInt();
                switch(ur){
                    case 1:User x = reg_user(users);
                    if(x.wallet!=-1){
                        users.add(x);
                    }
                    else{
                        System.out.println("Username not availabale");
                    }
                    break;
                    case 2:int ul = valid_user(users);
                    if(ul!=-1){
                        System.out.println("Login Successful");
                        Boolean user_exit=false;
                        while(!user_exit){
                            System.out.println("1-Book Tickets");
                            System.out.println("2-Cancel Tickets");
                            System.out.println("3-View Tickets");
                            System.out.println("4-Check Wallet Balance");
                            System.out.println("5-Add amount to Wallet");
                            System.out.println("6-Exit");
                            System.out.println("Enter Your Choice : ");
                            int uc = sc.nextInt();
                            switch(uc){
                                case 1:
                                for(int i=0;i<trains.size();i++){
                                    System.out.println(trains.get(i).id);
                                    System.out.println(trains.get(i).name);
                                    System.out.println("-------------------------------------");
                                }
                                System.out.println("Select The Train You Want To Book");
                                int trID = sc.nextInt();
                                System.out.println("-------------------------------------");
                                int ind=-1;
                                for(int i=0;i<trains.size();i++){
                                    if(trains.get(i).id==trID){
                                        ind = i;
                                    }
                                }
                                System.out.println("Number of Seats in train : "+trains.get(ind).arr[0].length);
                                System.out.println("Enter The number of seats : ");
                                int nos = sc.nextInt();
                                System.out.println("-------------------------------------");
                                if(nos<trains.get(ind).arr[0].length&&nos>0){
                                    ArrayList<Integer> seats = new ArrayList<>(); 
                                    System.out.println("Enter the seat no's : ");
                                    for(int i=0;i<nos;i++){
                                        seats.add(sc.nextInt());
                                    }
                                    System.out.println("-------------------------------------");
                                    Boolean b=true;
                                    for(int i=0;i<nos;i++){
                                        if(seats.get(i)<0&&seats.get(i)>=trains.get(ind).seats){
                                            b=false;
                                        }
                                    }
                                    if(b){

                                    for(int i=0;i<trains.get(ind).arr.length;i++){
                                        System.out.println(i);
                                    }
                                    System.out.println("Enter the from station : ");
                                    int from = sc.nextInt();
                                    System.out.println("-------------------------------------");
                                    System.out.println("Enter the to station : ");
                                    int to = sc.nextInt();
                                    System.out.println("-------------------------------------");
                                    if(from>=0&&from<trains.get(ind).stations&&to>0&&to<trains.get(ind).stations&&from<to){
                                        Boolean avail = true;
                                        for(int i=0;i<seats.size();i++){
                                            for(int j=from;j<=to;j++){
                                                if(trains.get(ind).arr[j][i]!=0){
                                                    avail=false;
                                                }
                                            }
                                        }
                                        if(avail){
                                            System.out.println("Tickets are available");
                                            int tamt = (trains.get(ind).amt*nos*(to-from+1)/(trains.get(ind).stations));
                                            System.out.println("Total Cost is : "+tamt);
                                            System.out.println("-------------------------------------");
                                            System.out.println("1-Pay From Wallet");
                                            System.out.println("2-Pay By Other Means");
                                            System.out.println("3-Not Now");
                                            int pay = sc.nextInt();
                                            switch(pay){
                                                case 1:if(users.get(ul).wallet>=tamt){
                                                    for(int i=0;i<seats.size();i++){
                                                        for(int j=from;j<to;j++){
                                                            trains.get(ind).arr[j][i]=1;
                                                        }
                                                    }
                                                    Ticket tick = new Ticket();
                                                    tick.amt = tamt;
                                                    tick.from = from;
                                                    tick.to = to;
                                                    tick.seatno = seats;
                                                    tick.train = trains.get(ind).id;
                                                    users.get(ul).Booked.add(tick);
                                                    users.get(ul).wallet-=tamt;
                                                    System.out.println("Booked Successfully");
                                                }
                                                else{
                                                    System.out.println("Insufficient Balance");
                                                }
                                                System.out.println("-------------------------------------");
                                                break;
                                                case 2:for(int i=0;i<seats.size();i++){
                                                    for(int j=from;j<=to;j++){
                                                        trains.get(ind).arr[j][i]=1;
                                                    }
                                                }
                                                Ticket tick = new Ticket();
                                                tick.amt = tamt;
                                                tick.from = from;
                                                tick.to = to;
                                                tick.train = trains.get(ind).id;
                                                users.get(ul).Booked.add(tick);
                                            }
                                            break;
                                            
                                        }
                                        else{
                                            System.out.println("Tickets Not Available");
                                        }
                                    }
                                    else{
                                        System.out.println("Enter Valid Stations");
                                    }
                                }
                                else{
                                    System.out.println("Invalid Seats");
                                }
                                }else{
                                    System.out.println("Enter a valid number of seats");
                                }
                                break;
                                case 2:for(int i=0;i<users.get(ul).Booked.size();i++){
                                    System.out.println(i);
                                    System.out.println("Train : "+users.get(ul).Booked.get(i).train);
                                    System.out.println("From : "+users.get(ul).Booked.get(i).from);
                                    System.out.println("To : "+users.get(ul).Booked.get(i).to);
                                    System.out.print("Booked Seats : ");
                                    for(int j=0;j<users.get(ul).Booked.get(i).seatno.size();j++){
                                        System.out.print(users.get(ul).Booked.get(i).seatno.get(j));
                                    }
                                    System.out.println();
                                    System.out.println("Total Amount : "+users.get(ul).Booked.get(i).amt);
                                    System.out.println("-------------------------------------");
                                }
                                int cb = sc.nextInt();
                                if(cb>=0&&cb<users.get(ul).Booked.size()){
                                    int tind=-1;
                                    for(int i=0;i<trains.size();i++){
                                        if(users.get(ul).Booked.get(cb).train==trains.get(i).id){
                                            tind=i;
                                        }
                                    }
                                    for(int i=users.get(ul).Booked.get(cb).from;i<users.get(ul).Booked.get(cb).to;i++){
                                        for(int j=0;j<users.get(ul).Booked.get(cb).seatno.size();j++){
                                            trains.get(tind).arr[i][users.get(ul).Booked.get(cb).seatno.get(j)]=0;
                                        }
                                    }
                                    users.get(ul).wallet+=users.get(ul).Booked.get(cb).amt;
                                    users.get(ul).Booked.remove(cb);
                                    System.out.println("Ticket Cancelled Successfully");
                                    System.out.println("-------------------------------------");
                                }
                                else{
                                    System.out.println("Ticket not cancelled");
                                    System.out.println("-------------------------------------");
                                }
                                break;
                                case 3:for(int i=0;i<users.get(ul).Booked.size();i++){
                                    System.out.println("Train : "+users.get(ul).Booked.get(i).train);
                                    System.out.println("From : "+users.get(ul).Booked.get(i).from);
                                    System.out.println("To : "+users.get(ul).Booked.get(i).to);
                                    System.out.print("Booked Seats : ");
                                    for(int j=0;j<users.get(ul).Booked.get(i).seatno.size();j++){
                                        System.out.print(users.get(ul).Booked.get(i).seatno.get(j));
                                    }
                                    System.out.println();
                                    System.out.println("Total Amount : "+users.get(ul).Booked.get(i).amt);
                                    System.out.println("-------------------------------------");
                                }
                                break;
                                case 4:System.out.println("Available Balance is : "+users.get(ul).wallet);
                                break;
                                case 5:System.out.println("Enter the amount you want to add : ");
                                int am = sc.nextInt();
                                if(am>0){
                                    users.get(ul).wallet+=am;
                                }
                                else{
                                    System.out.println("Enter a valid amount");
                                }
                                break;
                                case 6:user_exit = true;
                                break;
                                default : System.out.println("Enter a valid option");
                            }
                        }
                    }else{
                        System.out.println("Entered Credentils Doesnot Match");
                    }
                }
                break;
                case 3:whole_exit=true;
                break;
                default:System.out.println("Enter a valid option");
            }
        }
    }
}
