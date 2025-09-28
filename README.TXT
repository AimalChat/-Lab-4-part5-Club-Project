BlueJ project "club".

Authors: David J. Barnes and Michael Kölling

This project is supplementary material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Seventh edition
   David J. Barnes and Michael Kölling

Purpose of the project
=======================
The project is intended to extend understanding of object
collections. The exercises could be tackled after completing
Section 4.12 of Chapter 4.

The exercise
============
Membership of a club is represented by an instance of the
Membership class.  A complete version of the Membership class
is already provided for you in the club project, and it should
not need any modification.  Each Membership object contains
details of a person's name, and the month and year in which
they joined the club.  All membership details are filled out
when a Membership object is created.

Your task is to complete the Club class, an outline of which
has been also been provided in the club project.

The Club class is intended to store Membership objects in a
flexible-size collection.

A new Membership object is added to a Club object's collection
via the Club object's join method, which has the following
signature and description:

    /**
     * Add a new member to the club's collection of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)

You may assume that the Membership object passed as a
parameter has already been created and is fully initialized.

The Club class also defines a method to return how many
members are in the club. It has the following signature and
description:

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()

The number of members corresponds to the number of Membership
objects currently stored in the flexible-size collection.

Complete the definition of the Club class. This should
include:

    + A field to refer to a flexible-size collection
    object.

    + A no-arg constructor that sets up an appropriate
    flexible-size collection object to store Membership
    objects.

    + A full definition of the join method.

    + A full definition of the numberOfMembers method.

Below are some further challenge exercises for those who wish
to experiment with additional features of collections.

Possible Staged Implementation
==============================
This task has been broken down into suggested separate stages
to help you create the finished version in small steps. You
are recommended to compile and run the program after each
stage to check that the changes you have made are correct.

1. Define a field that will be used to refer to a
flexible-size collection object. Use an appropriate import
statement for this collection. In the constructor, create the
collection object and assign it to the field.

2. Complete the numberOfMembers method to return the current
size of the collection object. Of course, until you have
completed the join method, this will always return zero, but it
will be ready for further testing when the join method is
done.

3. Complete the join method.

When you wish to add a new Membership object to the Club
object from the object bench, there are two ways you can do
this.

    + Either create a new Membership object on the object
    bench, call the join method on the Club object, and click
    on the Membership object to supply the parameter.

    + Or call the join method on the Club object and type:

    new Membership("members name here ...", month-number-here, year-number-here)

    into the constructor's parameter dialogue box.

When you have added a new member use the numberOfMembers
method to check: a) That the join method is adding to the
collection, and b)That the numberOfMembers method is
working.

Challenge Exercises
===================
These challenge exercises are designed to take the club
project further towards a complete application. They
could be tackled after completing Section 4.9 of Chapter 4.

+ Define a method in the Club class with the following
signature and description:

    /** 
     * Return how many members joined in the given month. 
     * @param month The month we are interested in. 
     * @return How many members joined in the given month. 
     */
    public int joinedInMonth(int month) 

If the month parameter is outside the valid range of 1-12,
print an error message and return zero.

MY ANSWER:
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
            System.out.println("Month " + monthJoined + " out of range. Must be in 
            the range 1 ... 12");
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

+ Define a method in the Club class with the following
signature and description:

    /**
     * Remove from the club's collection all members who joined
     * in the given month, and return them stored in a separate
     * collection object.
     * @param month The month of the Membership.
     * @param year The year of the Membership.
     */
    public ArrayList purge(int month, int year)

If the month parameter is outside the valid range of 1-12,
print an error message and return a collection object with no
objects stored in it.

Note: the purge method is significantly harder to write than
any of the others.

MY ANSWER : 
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

Lab Report (part a = question, part b = answer)

40a.Use the club project to complete the following exercises. Your 
task is to complete the Club class, an outline of which has been 
provided in the project. The Club class is intended to store Membership 
objects in a collection. Within Club, define a field for an ArrayList. 
Use an appropriate import statement for this field, and think carefully 
about the element type of the list. In the constructor, create the 
collection object and assign it to the field. Make sure that all the 
files in the project compile before moving on to the next exercise.

40b.
import java.util.ArrayList;
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
        //initialise the collection of members here.
        listOfMembers = new ArrayList<Membership>();
    }


41a.Complete the numberOfMembers method to return the current size of 
the collection. Until you have a method to add objects to the collection, 
this will always return zero, of course, but it will be ready for further 
testing later.

41b.
    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return listOfMembers.size();
    }

42a.Membership of a club is represented by an instance of the Membership 
class. A complete version of Membership is already provided for you in the 
club project, and it should not need any modification. An instance contains 
details of a person’s name and the month and year in which they joined the 
club. All membership details are filled out when an instance is created. A 
new Membership object is added to a Club object’s collection via the Club 
object’s join method, which has the following description:
 /**
 * Add a new member to the club's collection of members.
 * @param member The member object to be added.
 */
 public void join (Membership member)
Complete the join method.
When you wish to add a new Membership object to the Club object from the 
object bench, there are two ways you can do this. Either create a new 
Membership object on the object bench, call the join method on the Club 
object, and click on the Membership object to supply the parameter or call 
the join method on the Club object and type into the method’s parameter 
dialog box:
 new Membership ("member name . . .", month, year)
Each time you add one, use the numberOfMembers method to check both that 
the join method is adding to the collection and that the numberOfMembers 
method is giving the correct result.

42b.
    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        listOfMembers.add(member);
    }

43a. Challenge exercise This and the following exercises present a challenge 
because they involve using some things that we have not covered explicitly. 
Nevertheless, you should be able to make a reasonable attempt at them if you 
have a comfortable grasp of the material covered so far. They involve adding 
something that most music players have: a “shuffle” or “random-play” feature.
The java.util package contains the Random class whose nextInt method will 
generate a positive random integer within a limited range. Write a method in 
the MusicOrganizer class to select a single random track from its list and play it. 

HINT: You will need to import Random and create a Random object, either 
directly in the new method or in the constructor and stored in a field. 
You will need to find the API documentation for the Random class and check 
its methods to choose the correct version of nextInt. Alternatively, we 
cover the Random class in Chapter 6

43b.

44a.Challenge exercise Consider how you might play multiple tracks in a random 
order. Would you want to make sure that all tracks are played equally or prefer 
favorite tracks? How might a “play count” field in the Track class help with 
this task? Discuss the various options.

44b.

45a. Challenge exercise Write a method to play every track in the track list 
exactly once in random order. 

HINT: One way to do this would be to shuffle the 
order of the tracks in the list—or, perhaps better, a copy of the list—and then 
play through from start to finish. Another way would be to make a copy of the list 
and then repeatedly choose a random track from the list, play it, and remove it 
from the list until the list is empty. Try to implement one of these approaches. 
If you try the first, how easy is it to shuffle the list so that it is genuinely 
in a new random order? Are there any library methods that could help with this?


45b.
