/*
 * Class:       CS 4308 Section 2
 * Term:        Fall 2019
 * Name:        Cody Ziegler, Steven Kemp
 * Instructor:   Deepa Muralidhar
 * Project:  Deliverable 2 Parser - Java
 */
package me.javajuliaprocessor;

import me.javajuliaprocessor.scanner.Token;
import me.javajuliaprocessor.scanner.TokenType;
import java.util.ArrayList;

public class Parser {
	private ArrayList<Object> tokens;

	public Parser(ArrayList<Object> t) {
		tokens = t;
	}

	/*
	 * This method will iterate through the token list and replace all the token
	 * with coupled values and statements in order to output the proper grammar.
	 * This should also handle some form of error handling in order to make sure
	 * that the program will run correctly.
	 */
	public ArrayList<Object> parse() {
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.INT_CONSTANT
						|| ((Token) tokens.get(i)).getType() == TokenType.IDENTIFIER) { // Literal Int or Identifier
					ValueCoupling value = new ValueCoupling((Token) tokens.get(i));
					tokens.set(i, value);
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.EXP_OP) { // Exponent op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.MUL_OP) { // multiply op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.DIV_OP) { // divide op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.REV_DIV_OP) { // reverse divide op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.MOD_OP) { // modulo op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.ADD_OP) { // add op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.SUB_OP) { // subtract op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						MathCoupling coupling = new MathCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}

		for (int i = 0; i < tokens.size(); i++) { // Boolean Couplings
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.LT_OP) { // lt op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						BooleanCoupling coupling = new BooleanCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				} else if (((Token) tokens.get(i)).getType() == TokenType.GT_OP) { // gt op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						BooleanCoupling coupling = new BooleanCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				} else if (((Token) tokens.get(i)).getType() == TokenType.NE_OP) { // not eq op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						BooleanCoupling coupling = new BooleanCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				} else if (((Token) tokens.get(i)).getType() == TokenType.EQ_OP) { // eq op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						BooleanCoupling coupling = new BooleanCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				} else if (((Token) tokens.get(i)).getType() == TokenType.GE_OP) {// ge op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						BooleanCoupling coupling = new BooleanCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				} else if (((Token) tokens.get(i)).getType() == TokenType.LE_OP) { // le op
					if ((tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)
							&& (tokens.get(i + 2) instanceof ValueCoupling
									|| tokens.get(i + 2) instanceof MathCoupling)) {
						BooleanCoupling coupling = new BooleanCoupling((Token) tokens.get(i), tokens.get(i + 1),
								tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}

		for (int i = 0; i < tokens.size(); i++) { // Iterators
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.ITERATOR) {
					if ((tokens.get(i - 1) instanceof ValueCoupling || tokens.get(i - 1) instanceof MathCoupling)
							&& (tokens.get(i + 1) instanceof ValueCoupling
									|| tokens.get(i + 1) instanceof MathCoupling)) { // error checker
						IterCoupling coupling = new IterCoupling((Token) tokens.get(i), tokens.get(i - 1),
								tokens.get(i + 1));
						tokens.set(i, coupling);
						tokens.remove(i - 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}

		// Assignment and Print statements
		for (int i = 0; i < tokens.size(); i++) { // Assignment Statement
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.ASSIGN_OP
						&& !(tokens.get(i + 1) instanceof IterCoupling)) {
					if ((tokens.get(i - 1) instanceof ValueCoupling
							&& ((ValueCoupling) tokens.get(i - 1)).token.getType() == TokenType.IDENTIFIER)
							&& (tokens.get(i) instanceof ValueCoupling || tokens.get(i) instanceof MathCoupling)) { // erroe
																													// checker
						AssignmentCoupling coupling = new AssignmentCoupling((Token) tokens.get(i), tokens.get(i - 1),
								tokens.get(i + 1));
						tokens.set(i, coupling);
						tokens.remove(i - 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
			if (tokens.get(i) instanceof Token) { // Print Statement
				if (((Token) tokens.get(i)).getType() == TokenType.PRINT) {
					if (tokens.get(i) instanceof ValueCoupling || tokens.get(i) instanceof MathCoupling) { // error
																											// check for
																											// print
						PrintCoupling coupling = new PrintCoupling((Token) tokens.get(i), tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						// error
					}
				}
			}
		}

		// Loops and if statements

		for (int i = 0; i < tokens.size(); i++) { // If Statement
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.IF) {
					if (tokens.get(i + 1) instanceof BooleanCoupling) { // error check
						int ifCount = 0, endCount = 0, elseIndex = i, endIndex = i;
						ArrayList<Object> ifBlock = new ArrayList<Object>(), elseBlock = new ArrayList<Object>();
						for (int j = i + 1; j < tokens.size(); j++) {
							if (tokens.get(j) instanceof Token) {
								if (((Token) tokens.get(j)).getType() == TokenType.IF) {
									ifCount++;
								} else if (((Token) tokens.get(j)).getType() == TokenType.ELSE && ifCount == 0) { // Correct
																													// else
									elseIndex = j;
									break;
								} else if (((Token) tokens.get(j)).getType() == TokenType.ELSE && ifCount != 0) { // Incorrect
																													// else
									ifCount--;
								}
							}
						}
						if (elseIndex == i) {
							// error due to not enough elses
						}
						for (int j = elseIndex + 1; j < tokens.size(); j++) {
							if (tokens.get(j) instanceof Token) {
								if (((Token) tokens.get(j)).getType() == TokenType.ELSE
										|| ((Token) tokens.get(j)).getType() == TokenType.WHILE
										|| ((Token) tokens.get(j)).getType() == TokenType.FOR) {
									endCount++;
								} else if (((Token) tokens.get(j)).getType() == TokenType.END && endCount == 0) { // Correct
																													// end
									endIndex = j;
									break;
								} else if (((Token) tokens.get(j)).getType() == TokenType.END && ifCount != 0) { // Incorrect
																													// end
									endCount--;
								}
							}
						}
						if (endIndex == i) {
							// error due to not enough ends
						}

						for (int j = i + 2; j < elseIndex; j++) {
							ifBlock.add(tokens.get(j));
						}
						for (int j = elseIndex + 1; j < endIndex; j++) {
							elseBlock.add(tokens.get(j));
						}
						IfCoupling coupling = new IfCoupling((Token) tokens.get(i), (Token) tokens.get(elseIndex),
								(Token) tokens.get(endIndex), tokens.get(i + 1), ifBlock, elseBlock);
						tokens.set(i, coupling);
						for (int j = i; j < endIndex; j++) {
							tokens.remove(j + 1);
						}
					} else {
						// error
					}
				}
			}
		}

		for (int i = 0; i < tokens.size(); i++) { // For Loop
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.FOR) {
					if ((tokens.get(i + 1) instanceof ValueCoupling
							&& ((ValueCoupling) tokens.get(i + 1)).token.getType() == TokenType.IDENTIFIER)
							&& ((Token) tokens.get(i + 2)).getType() == TokenType.ASSIGN_OP
							&& tokens.get(i + 3) instanceof IterCoupling) { // error checker
						int endCount = 0, endIndex = i;
						ArrayList<Object> forBlock = new ArrayList<Object>();
						for (int j = i + 1; j < tokens.size(); j++) {
							if (tokens.get(j) instanceof Token) {
								if (((Token) tokens.get(j)).getType() == TokenType.ELSE
										|| ((Token) tokens.get(j)).getType() == TokenType.WHILE
										|| ((Token) tokens.get(j)).getType() == TokenType.FOR) {
									endCount++;
								} else if (((Token) tokens.get(j)).getType() == TokenType.END && endCount == 0) { // Correct
																													// end
									endIndex = j;
									break;
								} else if (((Token) tokens.get(j)).getType() == TokenType.END && endCount != 0) { // Incorrect
																													// end
									endCount--;
								}
							}
						}
						if (endIndex == i) {
							// error due to not enough ends
						}

						for (int j = i + 4; j < endIndex; j++) {
							forBlock.add(tokens.get(j));
						}
						ForCoupling coupling = new ForCoupling((Token) tokens.get(i), (Token) tokens.get(i + 2),
								(Token) tokens.get(endIndex), tokens.get(i + 1), tokens.get(i + 3), forBlock);
						tokens.set(i, coupling);
						for (int j = i; j < endIndex; j++) {
							tokens.remove(j + 1);
						}
					} else {
						// error
					}
				}
			}
		}

		for (int i = 0; i < tokens.size(); i++) { // While Loop
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.WHILE) {
					if (tokens.get(i + 1) instanceof BooleanCoupling) { // error checker
						int endCount = 0, endIndex = i;
						ArrayList<Object> whileBlock = new ArrayList<Object>();
						for (int j = i + 1; j < tokens.size(); j++) {
							if (tokens.get(j) instanceof Token) {
								if (((Token) tokens.get(j)).getType() == TokenType.ELSE
										|| ((Token) tokens.get(j)).getType() == TokenType.WHILE
										|| ((Token) tokens.get(j)).getType() == TokenType.FOR) {
									endCount++;
								} else if (((Token) tokens.get(j)).getType() == TokenType.END && endCount == 0) { // Correct
																													// end
									endIndex = j;
									break;
								} else if (((Token) tokens.get(j)).getType() == TokenType.END && endCount != 0) { // Incorrect
																													// end
									endCount--;
								}
							}
						}
						if (endIndex == i) {
							// error due to not enough ends
						}

						for (int j = i + 2; j < endIndex; j++) {
							whileBlock.add(tokens.get(j));
						}
						WhileCoupling coupling = new WhileCoupling((Token) tokens.get(i), (Token) tokens.get(endIndex),
								tokens.get(i + 1), whileBlock);
						tokens.set(i, coupling);
						for (int j = i; j < endIndex; j++) {
							tokens.remove(j + 1);
						}
					} else {
						// error
					}
				}
			}
		}
		
		return tokens;
	}

	public void printGrammar() {
		// Method for printing the grammar of the program.
	}
}
