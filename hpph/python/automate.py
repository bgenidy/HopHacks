#!/usr/bin/python

import os
import sys
import shutil

if len(sys.argv) == 1:
	print "Invalid argument, automate.py /path/to/file "
else:
	shutil.copy(sys.argv[1], "C:\\Users\\Victoria\\Desktop\\hpph\\python\\tempSong\\")
	os.system("C:\\Python27\\python.exe "+"C:\\Users\\Victoria\\Desktop\\hpph\\python\\songs.py C:\\Users\\Victoria\\Desktop\\hpph\\python\\tempSong\\ > C:\\Users\\Victoria\\Desktop\\hpph\\python\\returnData.txt")
	