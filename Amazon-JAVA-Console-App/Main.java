import java.util.*;

class Admin{
    String password;
    String name;
    public static int findmerchant(ArrayList<Merchant> x,String Wish){
        Scanner sc = new Scanner(System.in);
        int i=-1;
        for(int v=0;v<x.size();v++){
            System.out.println(v+"-"+x.get(v).name);
        }
        System.out.println("Enter the merchant You Want To "+Wish);
        i=sc.nextInt();
        if((i<x.size())&&(i>=0)){
            return i;
        }
        else{
            return -1;
        }
    }
    public static int approvemerchant(ArrayList<Merchant> x,String Wish){
        Scanner sc = new Scanner(System.in);
        int i=-1;
        int c=0;
        for(int v=0;v<x.size();v++){
            if(!x.get(v).approval){
            System.out.println(v+"-"+x.get(v).name);
            c+=1;
            }
        }
        if(c>0){
        System.out.println("Enter the merchant You Want To "+Wish);
        i=sc.nextInt();
        if((i<x.size())&&(i>=0)){
            return i;
        }
        else{
            return -1;
        }
    }else{
        return -1;
    }
}

}
class User{
    String name;
    String password;
    ArrayList<HashMap<String,String>> MyOrders = new ArrayList<>();
    ArrayList<HashMap<String,String>> Cart = new ArrayList<>();
    public static ArrayList<String> add2cart(ArrayList<Merchant> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<x.size();i++){
            if(x.get(i).approval){
                for(int j=0;j<x.get(i).prod.size();j++){
                    System.out.println(i+""+j+"-"+x.get(i).prod.get(j));
                }
            }
        }
        System.out.println("Enter Your choice : ");
        String c = sc.next();
        int f=Character.getNumericValue(c.charAt(0));
        int s=Character.getNumericValue(c.charAt(1));
        if((f<x.size())&&(f>=0)&&(s<x.get(f).prod.size())&&(s>=0)){
            ans.add(Integer.toString(f));
            ans.add(Integer.toString(s));
            return ans;
        }
        else{
            ans.add(null);
            return ans;
        }
        
    }
    public static ArrayList<String> buyfromcart(ArrayList<HashMap<String,String>> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<x.size();i++){
            System.out.println(i+"-"+x.get(0));
        }
        System.out.println("Enter Your choice : ");
        int c = sc.nextInt();
        if((c<x.size())&&(c>=0)){
            ans.add(Integer.toString(c));
            ans.add(x.get(c).toString());
            return ans;
        }
        else{
            ans.add(null);
            return ans;
        }
        
    }
}
class Merchant{
    String password;
    String name;
    ArrayList<HashMap<String,String>> prod = new ArrayList<>();
    ArrayList<HashMap<HashMap<String,String>,String>> SalesReport = new ArrayList<>();
    Boolean approval =false;
    public static HashMap<String,String> addproduct(String merchant,ArrayList<String> c){
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> x = new HashMap<>();
        x.put("Merchant",merchant);
        System.out.println("Enter Product Name");
        x.put("name",sc.next());
        System.out.println("Enter Price");
        x.put("price",sc.next());
        for(int i=0;i<c.size();i++){
            System.out.println(i+"-"+c.get(i));
        }
        System.out.println("Enter Category");
        int v = sc.nextInt();
        if((v>=0)&&(v<c.size())){
        x.put("category",c.get(v));
        return x;
        }
        else{
            x.put("category", null);
            return x;
        }
    }




    public static ArrayList<String> updateproduct(ArrayList<HashMap<String,String>> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<x.size();i++){
            System.out.println(i+"-"+x.get(i));
        }
        System.out.println("Enter your Choice");
        int pr = sc.nextInt();
        ans.add(Integer.toString(pr));
        System.out.println("0-name");
        System.out.println("1-price");
        System.out.println("2-Exit");
        int ch = sc.nextInt();
        switch(ch){
            case 0:ans.add("name");
            break;
            case 1:ans.add("price");
            break;
            default:ans.add(null);
        }
        System.out.println("Enter what it needs to be changed : ");
        String val = sc.next();
        ans.add(val);
        return ans;
    } 
}
public class Main{
    public static User createuser(){
        Scanner sc = new Scanner(System.in);
        User x =new User();
        System.out.print("Enter Your name : ");
        x.name = sc.next();
        System.out.println("Enter Your Password : ");        
        x.password = sc.next();
        return x;

}
public static Merchant createmerchant(){
    Scanner sc = new Scanner(System.in);
    Merchant x =new Merchant();
    System.out.print("Enter Your name : ");
    x.name = sc.next();
    System.out.println("Enter Your Password : ");        
    x.password = sc.next();
    x.approval=false;
    return x;

}
    public static int valid_admin(ArrayList<Admin> x){
        int val=-1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter password : ");
        String password = sc.next();
        for(int i=0;i<x.size();i++){
            if((x.get(i).name.equals(name))&&(x.get(i).password.equals(password))){
                val=i;
            }
        }
        return val;
    } 
    public static int valid_merchant(ArrayList<Merchant> x){
        int val=-1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter password : ");
        String password = sc.next();
        for(int i=0;i<x.size();i++){
            if((x.get(i).name.equals(name))&&(x.get(i).password.equals(password))){
                val=i;
            }
        }
        return val;
    } 
    public static int valid_user(ArrayList<User> x){
        int val=-1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter password : ");
        String password = sc.next();
        for(int i=0;i<x.size();i++){
            if((x.get(i).name.equals(name))&&(x.get(i).password.equals(password))){
                val=i;
            }
        }
        return val;
    } 
    public static void main(String[] args) {
        ArrayList<String> category = new ArrayList<>();
        category.add("Electronics");
        Scanner sc = new Scanner(System.in);
        Merchant m1 = new Merchant();
        Admin a1 = new Admin();
        Admin a2 = new Admin();
        User u1 = new User();
        u1.name = "user1";
        u1.password = "u1u1";
        ArrayList<Admin> admins= new ArrayList<>();
        a1.name="admin1";
        a1.password="a1a1";
        a2.name="admin2";
        a2.password="a2a2";
        admins.add(a1);
        admins.add(a2);
        ArrayList<Merchant> merchant_list = new ArrayList<>();
        ArrayList<User> user_list = new ArrayList<>();
        m1.name="asus";
        m1.password="m1m1";
        m1.approval=true;
        HashMap<String,String> x = new HashMap<>();
        x.put("name", "rog");
        x.put("price","10000");
        x.put("category", "Electronics");
        x.put("Merchant","asus");
        HashMap<String,String> y = new HashMap<>();
        y.put("name", "vivobook");
        y.put("price","15000");
        y.put("category", "Electronics");
        y.put("Merchant","asus");
        m1.prod.add(x);
        m1.prod.add(y);
        merchant_list.add(m1);
        user_list.add(u1);
        Boolean exit_status=false;
        while(!exit_status){
            System.out.println("1-Admin");
            System.out.println("2-Merchant");
            System.out.println("3-User");
            System.out.println("4-Exit");
            System.out.println("Enter your choice : ");
            int per = sc.nextInt();
            switch(per){
                case 1:
                int i= valid_admin(admins);
                if(i!=-1){
                Boolean admin_exit_status=false;
                while(!admin_exit_status){
                    System.out.println("1-Approve merchants");
                    System.out.println("2-Remove merchants");
                    System.out.println("3-View Products");
                    System.out.println("4-Add category");
                    System.out.println("5-Exit");
                    System.out.println("Enter Your Choice : ");
                    int adc = sc.nextInt();
                    switch(adc){
                        case 1:int apm =admins.get(i).approvemerchant(merchant_list,"Approve");
                        if((apm!=-1)&&(!merchant_list.get(apm).approval)){
                            merchant_list.get(apm).approval=true;
                        }
                        else{
                            System.out.println("Merchant Already Approved or Invalid Option");
                        }
                    
                        break;
                        case 2:int rm = admins.get(i).findmerchant(merchant_list,"remove");
                        if(rm!=-1){
                        merchant_list.remove(rm);
                        }
                        else{
                            System.out.println("Invalid Option");
                        }
                        break;
                        case 3:for(int v=0;v<merchant_list.size();v++){
                            System.out.println(merchant_list.get(v).prod);
                        }
                        break;
                        case 4:System.out.println("Enter the category You want to add : ");
                                String cat = sc.next();
                                category.add(cat);
                        break;
                        case 5:admin_exit_status=true;
                        break;
                        default:System.out.println("Enter a valid choice : ");
                    }
                }
            }
                break;
                case 2:
                System.out.println("1-New Merchant");
                System.out.println("2-Existing Merchant");
                System.out.println("3-Exit");
                System.out.println("Enter Your Choice : ");
                int mo =sc.nextInt();
                switch(mo){
                    
                case 1:merchant_list.add(createmerchant());
                System.out.println("Registered Successfully");
                System.out.println("--Waiting For Approval--");
                break;

                case 2:int m =valid_merchant(merchant_list);
                if(m!=-1){
                    Boolean merchant_exit_status = false;
                    while(!merchant_exit_status){
                        System.out.println("1-Add products");
                        System.out.println("2-Update products");
                        System.out.println("3-View Products");
                        System.out.println("4-View sales report");
                        System.out.println("5-Exit");
                        System.out.println("Enter Your Choice : ");
                        int mec = sc.nextInt();
                        switch(mec){
                        case 1:HashMap<String,String> np = merchant_list.get(m).addproduct(merchant_list.get(m).name,category);
                        merchant_list.get(m).prod.add(np);
                        break; 
                        case 2:ArrayList<String> updp = merchant_list.get(m).updateproduct(merchant_list.get(m).prod);
                        if(updp.get(0)!=null){
                            merchant_list.get(m).prod.get(Integer.parseInt(updp.get(0))).replace(updp.get(1),updp.get(2));
                        } 
                        break;
                        case 3:System.out.println(merchant_list.get(m).prod);
                        case 4:System.out.println(merchant_list.get(m).SalesReport);
                        break;
                        case 5:merchant_exit_status=true;
    
                    }
                    }
                }
                case 3:break;
            }
                break;
                case 3:System.out.println("1-New User");
                System.out.println("2-Existing User");
                System.out.println("3-Exit");
                System.out.println("Enter Your Choice : ");
                int fup =sc.nextInt();
                switch(fup){
                    case 1:user_list.add(createuser());
                    System.out.println("Registered Successfully");
                    break;
                case 2:int u = valid_user(user_list);
                if(u!=-1){
                    Boolean user_exit_status = false;
                    while(!user_exit_status){
                        System.out.println("1-View products");
                        System.out.println("2-Add to cart");
                        System.out.println("3-Buy From Cart");
                        System.out.println("4-My Orders");
                        System.out.println("5-Exit");
                        System.out.println("Enter Your Choice : ");
                        int usc = sc.nextInt();
                        switch(usc){
                            case 1:for(int uvp =0;uvp<merchant_list.size();uvp++){
                                if(merchant_list.get(uvp).approval){
                                    System.out.println(merchant_list.get(uvp).prod);
                                }
                            }
                            break;
                            case 2:ArrayList<String> a2c = user_list.get(u).add2cart(merchant_list);
                            if(a2c.get(0)!=null){
                                user_list.get(u).Cart.add(merchant_list.get(Integer.parseInt(a2c.get(0))).prod.get(Integer.parseInt(a2c.get(1))));
                            }
                            break;
                            case 3:ArrayList<String> bfc = user_list.get(u).buyfromcart(user_list.get(u).Cart);
                            if(bfc!=null){
                                user_list.get(u).MyOrders.add(user_list.get(u).Cart.get(Integer.parseInt(bfc.get(0))));
                                int tm=-1;
                                for(int fm =0;fm<merchant_list.size();fm++){
                                    if (user_list.get(u).MyOrders.get(user_list.get(u).MyOrders.size()-1).get("Merchant")==merchant_list.get(fm).name){
                                        tm=fm;
                                    }
                                }
                                HashMap<String,String> cv = user_list.get(u).MyOrders.get(user_list.get(u).MyOrders.size()-1);
                                HashMap<HashMap<String,String>,String> h = new HashMap<>();
                                h.put(cv,user_list.get(u).name);
                                merchant_list.get(tm).SalesReport.add(h);
                            }
                            break;
                            case 4:System.out.println(user_list.get(u).MyOrders);
                            break;
                            case 5:user_exit_status=true;
                        }
                        
                    }

                }}
                break;
                case 4:exit_status=true;
                break;
                default:System.out.println("Enter a valid choice");
            }
        }
    }
}
