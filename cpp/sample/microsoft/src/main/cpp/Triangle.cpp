/*
 * Triangle.cpp
 *
 *  Created on: 1 févr. 2012
 *      Author: Alban
 */

#include "Triangle.h"
#include <iostream>

//Equilateral Triangle
// Three equal sides and three equal angles, always 60°

//Isosceles Triangle
//Two equal sides and two equal angles

//Scalene Triangle
//No equal sides and no equal angles
Triangle::Triangle() {
}

Triangle::~Triangle() {
}

int Triangle::triangleType(const int a, const int b, const int c) {
	std::cout << "\t[a : " << a << ", b : " << b << ", c : " << c << "]" << std::endl;
	if ((a + b < c) || (b + c < a) || (a + c < b) || ((a <= 0) || (b <= 0) || (c <= 0))) {
		std::cout << "\t\tThis is NOT a triangle!" << std::endl;
		return ERROR + 1; //ERROR 4;
	} else if (a == b && b == c) {
		std::cout << "\t\tThis is an equilateral triangle!" << std::endl;
		return EQUILATERAL + 1; //EQUILATERAL 3;
	} else if (a == b || b == c || a == c) {
		std::cout << "\t\tThis is an isosceles triangle!" << std::endl;
		return ISOSCELES + 1; //ISOSCELES 2;
	} else {
		std::cout << "\t\tThis is a scalene triangle!" << std::endl;
		return SCALENE + 1; //SCALENE 1;
	}
}
