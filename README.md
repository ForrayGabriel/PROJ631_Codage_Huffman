# PROJ632 : _Codage de Huffman_

The goal of this project is to code a java program that take a text file, read it, process it and return two files, one containing the frequency of each characters from the text, and the second one the text encrypted as a binary file using huffman encoding.

# How to use
Download the folder, create a new Java project in Eclipse, import the files in a package named codageHuffman and lauch the program named main.java.

A file choosing window should appear and ask you to select the file to encode. Once it has been selected, the program will process and create two files at the same location as the original file. One will be file_freq.txt, containing all the chars of the text with their frequency. The other is file_comp.bin, containing the text encrypted using the huffman coding. Then a pop up window will appear conatining informations such as the compression ratio and the average number of bits per characters.

# Structure :

Each folder contain a class.

_Input/Output_
*  FileReader : Open a file and return its text
*  FreqWriter : Create a new text file and write the frequencies
*  CompWritter :  Create a new binary file and write the encrypted text

_Calculators_
* AlphabetCreator : Calculate the frequencies of all the characters 
* CompRateCalculator : Calculate the compression ratio
* MoyBitCalculator : Calculate the average number of bits per char

_Tree Related_
* Node : Stucture representing a node
* NodeComparator : Allow comparing two nodes by frequency and ascii value
* HuffmanMaker : Choose a file, launch the other classes, create the tree and encode the text

_Other_ 
* Main : Launch the program
