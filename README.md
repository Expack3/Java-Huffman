#Huffman Compressor
Created and licened under the Unlicense by James McDermott

##Disclaimer:
This document will not help you set-up Java so standalone Java apps and applets can be run from the command-line as it assumes you know how to do so.

##Operation instructions:
The Huffman Compressor can only be run from the command-line and supports both relative and absolute filepaths. (Relative pathing will result in files being placed in the same folder as the JRE executable.) As such, the general syntax is as follows:
Java -jar [location of huffman.jar] [operation number] [location of input file] [desired location of output file] [(optional) (desired) location of decoder key]

For example, if you wanted to compress War and Peace, which is stored in the application’s directory as wap.txt, and you wanted to encode it to a file called encoded.txt and store it in C:\users\default\documents\wapFiles, you would type in the following on the command-line:

java –jar C:\guff\huffman.jar 1 C:\guff\wap.txt C:\users\default\documents\wapFiles\encoded.txt

wap.txt would then be compressed to encoded.txt, with decoded.txt stored at the defined location, and the decoder key would be created in your current working directory as characterFreqs.freq.

If you wanted to decode the file you created to a file called warAndPeace.txt and store the latter in D:\yourStuff\wap, and you wanted to use a decoder key stored in the file wapDecoderKey.txt at D:\yourStuff\wap, you would type in the following on the command-line:

-java huffman.jar 2 C:\users\default\documents\wapFiles\encoded.txt D:\yourStuff\wap\warAndPeace.txt D:\yourStuff\wap\wapDecoderKey.txt

encoded.txt would then be decoded to warAndPeace, which would be stored in the specified location, using the specified decoder key.
