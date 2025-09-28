import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version 7.0
 */
public class Club
{
    //List of membership objects
    private ArrayList<Membership> listOfMembers;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        //initialise the collection of members.
        listOfMembers = new ArrayList<Membership>();
    }
    
    /** 
     * Return how many members joined in the given month. 
     * @param month The month we are interested in. 
     * @return How many members joined in the given month. 
     */
    public int joinedInMonth(int monthJoined)
    {
        Iterator<Membership> it = listOfMembers.iterator();
        int membersJoinedInMonth = 0;
        if(monthJoined < 1  || monthJoined > 12)//when not in range is the condition.
        {
            System.out.println("Month " + monthJoined + " out of range. Must be in the range 1 ... 12");
        } else {while(it.hasNext()){
                    Membership m = it.next();//current member in collection.
                    int month = m.getMonth();//current member's join month.
                    if(month == monthJoined)
                    {
                        membersJoinedInMonth ++;
                    }
                }
        }
        return membersJoinedInMonth;
    }
    
    /**
     * Remove from the club's collection all members who joined
     * in the given month, and return them stored in a separate
     * collection object.
     * @param month The month of the Membership.
     * @param year The year of the Membership.
     */
    public ArrayList purge(int month, int year)
    {
        Iterator<Membership> it = listOfMembers.iterator();
        //List of removed members in Club.
        ArrayList listOfRemovedMembers= new ArrayList<Membership>();
        int membersJoinedInMonth = 0;
        int numberOfRemovedMembers = 0;
        int currentYear = 2025;
        if(month < 1  || month > 12)//when not in range is the condition.
        {
            System.out.println("Month " + month + " out of range. Must be in the range 1 ... 12");
        } else {if(year > currentYear){
                    System.out.println("Year " + year + " out of range. Must be 2025 or under.");
                } else{
                    while(it.hasNext()){
                        Membership m = it.next();//current member in collection.
                        int currentEvaluatedMonth = m.getMonth();//current member's join month.
                        int currentEvaluatedYear = m.getYear();//current member's join year. 
                        if(month == currentEvaluatedMonth && year == currentEvaluatedYear)
                        {
                            it.remove();
                            listOfRemovedMembers.add(m);
                        }
                    }
                }
        }
        return listOfRemovedMembers;
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        listOfMembers.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return listOfMembers.size();
    }
}
