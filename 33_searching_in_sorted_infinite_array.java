/*
Search target element in a sorted array of infinite elements

-> Put l = 0 and r = 1 initially
-> if the element lies between them or at the limits, then return the element
-> else reassign r = 2*r and l = r+1;
-> if exists then apply vanilla binary search
*/
