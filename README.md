# File deleter
A simple command-line tool to batch delete files.
## Usage
Since there is no graphical user interface (GUI), you may use the standard `java -jar` command, passing the tool file name as paramater.

After thath, the process is intuitive and prompted on screen.

First, you need to provide the full directory path wich contains the files you want to delete. It can be a parent folder containing subfolders. The tool will recursively search for your files in all the subfolders.

Then, you need to provide the file extension you want to delete, without the leading dot. For example: "png" would match all files ending with ".png".

That's it. The tool will output how many files were found (if any), and ask you for confirmation. Your files won't be deleted until you type "y" to confirm the deletion. Typing any character other than "y" will abort the operation. Aborting won't delete any of your files.

### Screenshot
<img src="https://i.imgur.com/J85nnir.png" />
