#include <stdio.h>
#include <iostream>

enum TriangleType {
	SCALENE, ISOSCELES, EQUILATERAL, ERROR
};

static int triangleType(const int a, const int b, const int c) {
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

int main(int argc, char** argv) {

	std::cout << "START test case ERROR" << std::endl;
	if (4 == triangleType(0, 0, 0)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(1, 0, 0)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(0, 1, 0)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(0, 0, 1)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(1, 1, 0)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(0, 1, 1)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(1, 0, 1)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(1, 2, 4)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(5, 6, 12)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(12, 5, 6)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (4 == triangleType(6, 12, 5)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	std::cout << "END test case ERROR" << std::endl;

	std::cout << "START test case EQUILATERAL" << std::endl;
	if (3 == triangleType(1, 1, 1)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (3 == triangleType(4, 4, 4)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	std::cout << "END test case EQUILATERAL" << std::endl;

	std::cout << "START test case ISOSCELES" << std::endl;
	if (2 == triangleType(10, 10, 8)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (2 == triangleType(9, 5, 5)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (2 == triangleType(7, 10, 7)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	std::cout << "END test case ISOSCELES" << std::endl;

	std::cout << "START test case SCALENE" << std::endl;
	if (1 == triangleType(1, 2, 3)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (1 == triangleType(4, 5, 3)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	if (1 == triangleType(3, 2, 1)) {
		std::cout << "\t\t\tSUCESSED" << std::endl;
	} else {
		std::cerr << "\t\t\tFAILED" << std::endl;
	}
	std::cout << "END test case SCALENE" << std::endl;

}
