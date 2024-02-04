public class pizza
{
    private int price;
    private boolean veg;
    
    private int extraCheesePrice = 100;
    private int addExtraToppingprice = 150;
    private int backPackprice = 20;
    private int basepPizzaprice;

    private boolean isExtraCheeseAdded = false;

    private boolean isExtraToppingAdded = false;

    private boolean isOptedForTakeAway = false;
    public pizza(boolean veg)
    {
        this.veg = veg;
        if (this.veg)
        {
            this.price = 300;
        } else
        {
            this.price = 400;
        }
       backPackprice = this.price;

    }
    //  public void getpizzaprince() 
	// 	{
	// 		System.out.println(this.price);
	// 	}
    public void addExtraCheese()
    {
        // System.out.println("Extra Cheese added");
        this.price+=extraCheesePrice;
    }
      public void addExtraTopping()
    {
        // System.out.println("Extra Topping added");
        this.price+=addExtraToppingprice;
    }  
    public void takeAway()
    {
    //    System.out.println("Take away opted");
       this.price+=backPackprice;   
    }  
    public void getBill()
    {
        System.out.println("pizza:"+backPackprice );
        if(isExtraCheeseAdded)
        {
            bill += "Extra cheese added:" +extraCheesePrice+"\n";
        } 
        if (isExtraToppingAdded)
        {
            bill += "Extra Topping added:"+extraToppingPrice+ "\n";
        }
         if (isOptedForTakeAway) 
        {
            bill += "Take aways:"+backPackPrince+ "\n";
        }
        bill +="Bill:"+this.price+"\n";
        System.out.println(bill);
        
    }
}