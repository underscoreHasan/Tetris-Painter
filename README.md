# Hasan Noor's Personal Project
## Tetris Painter

- What will the application do?

    - The application will provide a graphical environment to paint in that can be controlled by the users keyboard.
  The app will be rendered simply and will follow the rules of a Tetris board. To save a state of a painting, the user
  would have to click a save button the game. A score will also be tracked.


- Who will use it?

    - The application could be used by **anyone** who wants to use the painter and has a computer that is able to render it.


- Why is this project of interest to you?
    - This project is of interest to me since I have never coded a GUI-based application that requires large amounts of
  user interaction before.

## User Stories:

- As a user, I want to be able to control the movement of Tetris blocks.
- As a user, I want to be able to control the orientation of Tetris blocks.
- As a user, I want random Tetris blocks to be generated.
- As a user, I want to be able to view what my current score is.
- As a user, I want to be able to control the painter using my keyboard.
- As a user, I want to be able to place a block on a collection of placed blocks.
- As a user, I want to be able to save the state of my painting to file (if I so choose)
- As a user, I want to be able to be able to load the saved state of my painting from file (if I so choose)

## Attributions:
- The Console UI in this project draws inspiration from the implementation of the UI in TellerApp. 
- The GUI in this project draws inspiration from the implementation of the UI in SpaceInvadersBase.
- The JsonReader and JsonWriter classes in this project draw inspiration from the implementation of the JsonReader and JsonWriter in JsonSerializationDemo.

# Instructions for Grader
- You can generate the first required action related to adding Xs to a Y by pressing the Spacebar.
- You can generate the second required action related to adding Xs to a Y by pressing the R key.
- You can locate my visual component by looking at the center panel with blocks on it in the GUI.
- You can save the state of my application by clicking the save button.
- You can reload the state of my application by clicking the load button.

# Phase 4: Task 2:

Sample Event Log:

Wed Apr 12 14:29:23 PDT 2023
Added O-shaped block at AnchorPoint: [5,2]

Wed Apr 12 14:29:24 PDT 2023
Added Z-shaped block at AnchorPoint: [5,8]

Wed Apr 12 14:29:25 PDT 2023
Added L-shaped block at AnchorPoint: [2,5]

Wed Apr 12 14:29:27 PDT 2023
Added J-shaped block at AnchorPoint: [9,3]

Wed Apr 12 14:29:28 PDT 2023
Removed latest placed block from fixedBlocks: J-shaped block at AnchorPoint: [9,3]

Wed Apr 12 14:29:29 PDT 2023
Removed latest placed block from fixedBlocks: L-shaped block at AnchorPoint: [2,5]

Wed Apr 12 14:29:31 PDT 2023
Added T-shaped block at AnchorPoint: [3,5]

Wed Apr 12 14:29:33 PDT 2023
Added S-shaped block at AnchorPoint: [8,11]

Wed Apr 12 14:29:36 PDT 2023
Removed latest placed block from fixedBlocks: S-shaped block at AnchorPoint: [8,11]

Wed Apr 12 14:29:36 PDT 2023
Removed latest placed block from fixedBlocks: T-shaped block at AnchorPoint: [3,5]

Wed Apr 12 14:29:36 PDT 2023
Removed latest placed block from fixedBlocks: Z-shaped block at AnchorPoint: [5,8]

Wed Apr 12 14:29:37 PDT 2023
Removed latest placed block from fixedBlocks: O-shaped block at AnchorPoint: [5,2]

Wed Apr 12 14:29:37 PDT 2023
No blocks placed, nothing can be removed!

# Phase 4: Task 3:

Looking at my UML class diagram, there are circular field relationships in my GUI to Block and BlockHeap. The reason for
this is maintaining focus of the controlBlock required construction of a new GamePanel object and replacing the old reference,
instead of handling the change by repainting the existing GamePanel. This could have been corrected if I had deeper knowledge 
of the Swing library and the painting methods.

I could also improve my implementation of the specific Block types by having mathematically calculated rotations instead
 of static "rotation states". This would have reduced the chances of human error when creating and hardcoding the rotation
 states.