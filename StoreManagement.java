import java.util.Scanner;
import java.util.Arrays;

//main class
class StoreManagement
{
    static int last_count = 0;
    static StringBuffer productName[] = new StringBuffer[10];
    static double productPrice[] = new double[10];
    static int productQuantity[] = new int[10];
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        while(quit == false)
        {
            System.out.println("--------WELCOME TO GADA ELECTRONIICS--------");
            System.out.println("Enter\t1\tShow Product Details");
            System.out.println("Enter\t2\tUpdate Details");
            System.out.println("Enter\t3\tAdd New Product");
            System.out.println("Enter\t4\tQuit");
            int userinput = scan.nextInt();

            switch(userinput)
            {
                case 1:
                    System.out.print("\n--------------------------------------------\n");
                    ShowDetail show = new ShowDetail();
                    show.dispDetail();
                    System.out.print("\n--------------------------------------------\n");
                    break;
                case 2:
                    System.out.print("\n--------------------------------------------\n");
                    System.out.println("Which Product Details you want to Update ? ");
                    scan.nextLine();
                    String updateprod =scan.nextLine().trim();
                    boolean bool = false;
                    for(int temp = 0;temp < StoreManagement.last_count;temp++)
                    {
                        if (StoreManagement.productName[temp].toString().equals(updateprod))
                        {
                            System.out.println("Product Name\tPrice\t\tQuantity");
                            System.out.println(StoreManagement.productName[temp].toString() + "\t\t" + StoreManagement.productPrice[temp] + "\t\t" + StoreManagement.productQuantity[temp]);
                            index = index + temp;
                            bool = true;
                        }
                    }
                    if(bool == false)
                    {
                        System.out.println("Product not found !");
                    }
                    else
                    {
                        System.out.println("What you want to update ?");
                        System.out.println("Enter\t1\tProduct Name");
                        System.out.println("Enter\t2\tProduct Price");
                        System.out.println("Enter\t3\tProduct Quantity");
                        int input = scan.nextInt();
                        scan.nextLine();
                        UpdateDetail ud = new UpdateDetail();
                        switch (input)
                        {
                            case 1:
                                System.out.print("Enter new name : ");
                                String pn = scan.nextLine();
                                ud.updateName(index,pn);
                                System.out.println("Updated Details :");
                                System.out.println("Product Name\tPrice\t\tQuantity");
                                System.out.println(StoreManagement.productName[index].toString() + "\t\t" + StoreManagement.productPrice[index] + "\t\t" + StoreManagement.productQuantity[index]);
                                break;
                            case 2:
                                System.out.print("Enter new price : ");
                                double pp = scan.nextDouble();
                                ud.updatePrice(index,pp);
                                System.out.println("Updated Details :");
                                System.out.println("Product Name\tPrice\t\tQuantity");
                                System.out.println(StoreManagement.productName[index].toString() + "\t\t" + StoreManagement.productPrice[index] + "\t\t" + StoreManagement.productQuantity[index]);
                                break;
                            case 3:
                                System.out.print("Enter new quantity : ");
                                int pq = scan.nextInt();
                                ud.updateQuantity(index,pq);
                                System.out.println("Updated Details :");
                                System.out.println("Product Name\tPrice\t\tQuantity");
                                System.out.println(StoreManagement.productName[index].toString() + "\t\t" + StoreManagement.productPrice[index] + "\t\t" + StoreManagement.productQuantity[index]);
                                break;
                        }
                    }
                    System.out.print("\n--------------------------------------------\n");
                    break;
                case 3:
                    System.out.print("\n--------------------------------------------\n");
                    //how many products the user want to add in the array
                    System.out.print("How many Products you want to add : ");
                    int addpro = scan.nextInt();
                    scan.nextLine();//it will consume the next line because nextInt can't
                    for(int i = 0;i < addpro;i++)
                    {
                        //taking product name from user
                        System.out.print("Enter Product Name : ");
                        StoreManagement.productName[StoreManagement.last_count] = new StringBuffer(scan.nextLine());

                        //taking product price from user
                        System.out.print("Enter Product Price : ");
                        StoreManagement.productPrice[StoreManagement.last_count] = scan.nextDouble();
                        scan.nextLine();//it will consume the next line because nextInt can't

                        //taking product quantity from user
                        System.out.print("Enter Product Quantity : ");
                        StoreManagement.productQuantity[StoreManagement.last_count] = scan.nextInt();
                        scan.nextLine();//it will consume the next line because nextInt can't

                        //it will pointing to the last index of array
                        StoreManagement.last_count++;
                    }
                    System.out.print("\n--------------------------------------------\n");
                    break;
                case 4:
                    System.out.print("\n--------------------------------------------\n");
                    quit = true;
                    System.out.print("Program Closed !");
                    System.out.print("\n--------------------------------------------\n");
                    break;
                default:
                    System.out.print("\n--------------------------------------------\n");
                    System.out.println("Please Choose from the above options !");
                    System.out.print("\n--------------------------------------------\n");
                    break;
            }
        }
    }
}

//class with display method to show the product details
class ShowDetail
{
    //this method will show the product details
    void dispDetail()
    {
        if(StoreManagement.last_count <= 0)
        {
            System.out.println("No Product in the List");
        }
        else
        {
            System.out.println("Product Name\tPrice\t\tQuantity");
            for(int j = 0;j < StoreManagement.last_count;j++)
            {
                System.out.println(StoreManagement.productName[j].toString()+"\t\t"+StoreManagement.productPrice[j]+"\t\t"+StoreManagement.productQuantity[j]);//displaying details of each product
            }
        }
    }
}

//class with update methods which will update the product name, product price and quantity of the existing products
class UpdateDetail
{
    //method to update name
    void updateName(int ind,String name)
    {
        StoreManagement.productName[ind] = new StringBuffer(name);
    }
    //method to update price
    void updatePrice(int ind,double price)
    {
        StoreManagement.productPrice[ind] = price;
    }
    //method to update quantity
    void updateQuantity(int ind,int quantity)
    {
        StoreManagement.productQuantity[ind] = quantity;
    }
}
