# TItle
 Wildlife-tracker

 ## Author
 Paul Onyango
 A software developer.


## Description
 An app that allows Rangers to track wildlife sightings in the area.

## Project set up
 * Open the terminal in your device.
 * git clone
 * Open the project in Intellij IDEA
 * Run the program 
### Database setup
 *CREATE DATABASE wildlife_tracker;
 *CREATE TABLE animal (id serial PRIMARY KEY,name varchar,location varchar);
 *CREATE TABLE endangered_animals (id serial primary key,animalid int,name varchar,health varchar,age int,location varchar);
 *CREATE TABLE sightings (id serial primary key,animal_id varchar,location varchar,ranger_name);


 

## Technologies used

* Java
*Spark


## Behaviour Driven Development(BDD) 
When you run the app you are welcomed.Their is a navigation that allows users to select which animal you want to report.After that form pops up where one need to feel in the credentials then submit after that you are informed that the process was successful.


 ### Contacts
  Email:paulnyango021@gmail.com

## Licence
MIT License

Copyright (c) [2020] [PAUL Onyango]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
