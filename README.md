# Android_Sprint8Challenge_CongressDebug

## Instructions

**Please read this entire README to make sure you understand what is expected of you before you begin.**

This sprint challenge is designed to ensure that you are competent with the concepts taught throughout Sprint 8.

In your solution, it is especially important that you follow best practices such as MVC and good, consistent code style. You will be scored on these aspects as well as the project MVP (minimum viable product) requirements below.

Fork this repository and clone your fork to your computer. Use the existing Android Studio project in this cloned fork repository folder, then commit and create a pull request. Commit appropriately as you work. When finished, push your final project to GitHub and comment on the pull requestto indicate that your project is complete.

You have *3 hours*, and you should work *independently* — looking things up (search, notes) is all fair game. And questions about *process* / *logistics* (i.e. if you have a hard time opening/saving to GitHub) are fair game too.

Good luck!

## Screen Recording

This screen recording shows how the app should look. Use this when designing your test cases. 

<img src="congress_debug_recording.gif" width="300">

## Requirements

The goal of this application is threefold. You must debug this Congressperson Information project, write unit tests, as well as UI tests for the portions specified.
> When debugging, be sure to note the bugs you fixed in your readme so that your PM can use that as a reference.

The requirements for this project are as follows:

1. Write unit tests for the `OfficialOverview` class, be sure to use the screen recording above as a reference to the output.
2. Fix any bugs surfaced by your unit tests.
3. Write UI tests for the top portion of the Details Activity
> Remember to provide a static id for testing. You may want to refactor the details activity to accept an entire object for more consistent testing (save that for the end)

4. Run the profiler to look for performance bugs. The app doesn't have to be perfect, but when you look at the CPU profiler, you'll see a number of glaring issues that will be a huge boost to the performance.

## Go Further

After you finish with these requirements, spend the rest of the time improving coverage on your unit tests, improving the UI tests and improving overall performance.


Issues Found:
1. removed .toLowerCase() method in OfficialOverview to make the display name display properly.
2. (performance improvement) commented out the line in the repo that pulled all pics and made it download the picture in the details activity when you click the person to smooth out the user experience. (was spiking alot with the pulling of all congresspeople at once)
3. added a space between names in the build display name in official overview.
4. removed the 2nd onCreate
5. misc cleanup of unused code as well as cleaning extra whitespace .

