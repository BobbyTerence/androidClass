# Android Class
As part of my education at State Tech, I am taking a basic Mobile applications class for both Android and Apple, this is the repo for just the Android projects.

## Overview
I have the same instructor for this class as I did the COBOL class, but his way of teaching this class is much more cohesive with how I learn in general, so the whole process has been much better than COBOL was.
With that said, how he is teaching this course is that he is walking us through the basic principles of how to do the assignment for the week, just implemented in a slightly different way. So there will be one folder
with all of the example projects that we worked on, and then each assignment will have its own folder

## Assignments

### namesProj
_________
NamesProj was our first assignment, which was just "Hello World!", but using our family instead, with the addition that we had to add one relation to the page. The in class example for this is the `HelloWorld` project

### wtfHobby
___________
WtfHobby is an assignment where we had to implement a button that switched between different pages of the application. The questionable name of the project is just my initials though. The in class example for this assignment
is the `breadRecipe` project.

### wflowersconverter
___________
Wflowersconverter was a simple assignment where we had to convert USD to several other currencies. We learned how to change the value of textViews at a button click for this assignmen. The in class example is `monJan29`.

### widgetSale
_________
For widgetSale, we had to make a simple page that allowed the user to select between four different widgets, and purchase an amount of them. This was an extension of the converter assignment, except this time we add an #image# from the drawable folder.
The in class example for this is `concertTicket`

### StateTechList
_________
StateTechList was the first time that we used the ListActivity class in order to create a list at runtime using an array that was created in the MainActivity class. We had to create six different list items, three of them linked to an outside page, and the other three
switched views to an image of State Tech's campus. The in class example for this assignment is `listChi`.

### wtfFarmSounds
_________
wtfFarmSounds was where we learned how to setup a splash screen and incorporate audio files into out applications. Upon looking into it, it seems that our book is a little outdated, as the implementation for this is to just set up the splash screen as the backgground image of a `plainText` view, so I set the background image of the activity as a whole before utilizing the `TimerTask` function to switch views. I was out of lecture for most of the week of this assignment, so I do not have the in class example to compare it to.

### gridSounds
________
gridSounds was our first application using a gridView. In this project we also learned a little bit more about handling sound files and playback controls. I even made it to where the file resumes from the beginning every time you click it again. The in class example for this one is `EndangeredSpecies` class example.

### CatfishTourney
_________
CatfishTourney was our first application where he just gave us a task to do without any specific technique. This one was a little bit more difficult as our teacher didn't really give us a clear path to come up with our solution, which was a lot more fun. I ended up using an `AlertDialog.Builder` which would create a Dialog box that allowed the user to input the weight of a catfish that they had caught. It would then compare that weight to up to three other catfish, and it would either replace the lowest weight fish, or simply add it to the list. That wasn't it though, as we had to make the option to chose from three different catfish, and their weight's would be calculated differently based on the type of fish it was. There is no in class example for this one.

### animator
__________
animator was the first project we did to incorporate simple animations. This required us to make a few of out own .xml files to determine how the affected element would move. Overall, this was a very simple task, just a little boring because the only new thing was the animation, and how learned how to do it was not difficult at all. `northernLights` is the in class example for this assignment.

### KurgerBingFinal
_________
This was our final project for the class, I will be creating a seperate repository for it if you would like to look at it on it's own. We ended up working together in a team setting, and our teacher wanted us to incorporated all of the different techniques we learned in the class, other than that, he did not care what the application did. The requirements in question are; a splash screen, images, links to external sources, page changes, passing information to a different page, animation, sounds, and dialog boxes. My group decided to make a Burger King spoof ordering application. This allowed you to select however many items out of three options. I worked together with two other class mates. One of them handled the Main Page, as well as setting up a majority of the data transfer system, he doesn't like commenting his code as part of some pride thing. I ended up making the other two pages, and the splash screen, as well as implementing a lot of the random requirements we needed for the application.