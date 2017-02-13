# BigDataEnginerring
Big Data Class 2017
This Repository will conatin Assignment Related to R and NOSQL Data Bases and Project.

# Assignment 1
# Part 1
1. Read all papers on Blackboard. Pick one of them and write a short paper on it, max 3 pages
2. Write a 5-minute presentation.  Plan to deliver it next class (maybe)
3. Textbook reading assignments (optional): – Chapters3,4.9,and10

# Part 2
Set up two Hadoop infrastructures based on:
– Linux people: Native Hadoop or Cloudera
– Windows people: Hadoop on Cygwin
– Mac People: Native Hadoop
– Follow instructions in Installing Hadoop document on Blackboard
– Set up Hadoop 0.20.2 as well as latest Hadoop

# Part 3
Install your personal Hypervisor & 2 VMs:
– Oracle VirtualBox or VMWare Workstation
– Windows 10 VM, and Ubuntu VM

#Part 4
Do it in VisualStudioCode(C#) – Based on Fibonacci posted example
1. Write a prime number generating coroutine in C#
2. Solve https://projecteuler.net/problem=7
3. Write a Primonacci number generating coroutine in C#. What is the 10,001st Primonacci number?
4. Primonacci = Fibonacci sequence of primes instead of naturals


# Assignment 2
# Part 1: Plotly
1. Go to https://plot.ly/ipython-notebooks/survival-analysis-r-vs-python/
2. Copy paste the R code (ignore Python code) into R studio. Execute it to see the analysis presented on the above link.
3. Now, you have to do something similar.
4. Find a new dataset related to survival analysis.
5. Perform some sort of survival analysis and present your findings in the form of Plotly charts. Refer to latest documentation on how to push the chart from your local RStudio to your online Plotly account.
6. Don't forget to capture the highlights of your understanding in the report as well as the link to your publicly available Plotly chart.

# Part 2: R labs
Complete the exercises for homework. Share screenshots of output along with source code.

# Part 3: Hadoop Lab 1
1. Just understand how to execute a Hadoop job in stand-alone mode (simple mode). 
You don't need any configurations in conf/*-site.xml files. Share the screenshot of execution.


# Assignment 3
# Part 1 - R
1. Plot word cloud for Iliad and Odyssey
2. Add color
3. Do some clustering, you pick what makes sense to cluster
4. What are characteristics of the Iliad and the Odyssey that are in common?

# Part 2 - Hadoop MapReduce
1. Compute the factorial of 1,000,000 using Hadoop MapReduce. The numbers from 1 to 1,000,000 should be present in a file that you read in your code.
2. Compute the value of pi using Hadoop MapReduce, leveraging the Leibniz formula. The numbers from 1 to 1,000,000 should be present in a file that you read in your code.

# Part 3 - Hadoop MapReduce
1. Find all IP addresses with more than 100 hits in decreasing order. 
You may not sort manually nor write a program to sort. 
You may need to run multiple map or reduce operations! Please refer to the slides to see the expected output format.

# Assignment 4
Page Rank Algorithm
1. WIKISPECIES PAGERANK:
Information - understand the bigger picture
For this week, you are going to get ready for delivering the homework for the Monday after next, where you are going to find the most popular species on wiki species using the PageRank algorithm
But you are still going to submit homework this week. Just that your results need not be as polished, yet.
Download wikispecies straight from wikimedia or use the compressed XML on blackboard
To do this, you are going to have to mapreduce with the XML data type. Since building hadoop data types is not super easy, I'll give this type to you next week.

# Task - due this week - execute and analyze the code for the smaller input file

1- For now, you can start with the smaller, dataset on blackboard, that is already sharded to be in text format, one line per record
Iterate until you see that the PageRank deltas get smaller, you don't have to converge completely.
If, for some reason, you see junk appearing in the data, get rid of it in your code
Chain your mapreduces with a loop in your driver

2. OPTIONAL - Extra Credits:  Predict long-term dynamics of a Markovian system of your choice.

