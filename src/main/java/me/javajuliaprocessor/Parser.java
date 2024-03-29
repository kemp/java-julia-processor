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
	private IdentifierTable IT;

	public Parser(ArrayList<Object> t) {
		tokens = t;
		IT = new IdentifierTable();
	}

	/*
	 * This method will iterate through the token list and replace all the token
	 * with coupled values and statements in order to output the proper grammar.
	 * It also handles errors if there are any in the code.
	 * After it has parsed the entire program the main method will call
	 * its interpret method that will then iterate through the couplings
	 * and execute the input program.
	 */
	public ArrayList<Object> parse() {
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i) instanceof Token) {
				if (((Token) tokens.get(i)).getType() == TokenType.INT_CONSTANT
						|| ((Token) tokens.get(i)).getType() == TokenType.IDENTIFIER) { // Literal Int or Identifier
					ValueCoupling value = new ValueCoupling((Token) tokens.get(i), IT);
					tokens.set(i, value);
				}
			}
		}
		
		// Math Couplings
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: ^ <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: * <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: / <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: \\ <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: % <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: + <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: - <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: < <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: > <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: != <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: == <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: >= <Math Value> <Math Value>");
						System.exit(0);
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
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: <= <Math Value> <Math Value>");
						System.exit(0);
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
						tokens.remove(i + 1);
						tokens.remove(i - 1);
						i--;
					} else {
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: <Math Value> : <Math Value>");
						System.exit(0);
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
							&& (tokens.get(i + 1) instanceof ValueCoupling || tokens.get(i + 1) instanceof MathCoupling)) { // error
																													// checker
						AssignmentCoupling coupling = new AssignmentCoupling((Token) tokens.get(i), tokens.get(i - 1),
								tokens.get(i + 1));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i - 1);
						i--;
					} else {
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: <Math Value> = <Math Value>");
						System.exit(0);
					}
				}
			}
			if (tokens.get(i) instanceof Token) { // Print Statement
				if (((Token) tokens.get(i)).getType() == TokenType.PRINT) {
					if (tokens.get(i + 2) instanceof ValueCoupling || tokens.get(i + 2) instanceof MathCoupling) { // error
																											// check for
																											// print
						PrintCoupling coupling = new PrintCoupling((Token) tokens.get(i), tokens.get(i + 2));
						tokens.set(i, coupling);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
						tokens.remove(i + 1);
					} else {
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: print ( <Math Value> )");
						System.exit(0);
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
							System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
									+ "\nNo matching else statement");
							System.exit(0);
						}
						for (int j = elseIndex + 1; j < tokens.size() - 1; j++) {
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
							System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
									+ "\nNo matching end statement");
							System.exit(0);
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
							tokens.remove(i + 1);
						}
					} else {
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: if <Boolean Expression> <Block of Code> else <Block of Code> end");
						System.exit(0);
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
						for (int j = i + 1; j < tokens.size() - 1; j++) {
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
							System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
									+ "\nNo matching end statement");
							System.exit(0);
						}

						for (int j = i + 4; j < endIndex; j++) {
							forBlock.add(tokens.get(j));
						}
						ForCoupling coupling = new ForCoupling((Token) tokens.get(i), (Token) tokens.get(i + 2),
								(Token) tokens.get(endIndex), tokens.get(i + 1), tokens.get(i + 3), forBlock);
						tokens.set(i, coupling);
						for (int j = i; j < endIndex; j++) {
							tokens.remove(i + 1);
						}
					} else {
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: for identifier = <Iterator> <Block of Code> end");
						System.exit(0);
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
						for (int j = i + 1; j < tokens.size() - 1; j++) {
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
							System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
									+ "\nNo matching end statement");
							System.exit(0);
						}

						for (int j = i + 2; j < endIndex; j++) {
							whileBlock.add(tokens.get(j));
						}
						WhileCoupling coupling = new WhileCoupling((Token) tokens.get(i), (Token) tokens.get(endIndex),
								tokens.get(i + 1), whileBlock);
						tokens.set(i, coupling);
						for (int j = i; j < endIndex; j++) {
							tokens.remove(i + 1);
						}
					} else {
						System.out.println("Line number: " + ((Token) tokens.get(i)).getLineNumber() 
								+ "\nExpected: while <Boolean Expression> <Block of Code> end");
						System.exit(0);
					}
				}
			}
		}
		return tokens;
	}

	public void printGrammar() {
		// Method for printing the grammar of the program.
		System.out.println("\n<Program> -> function id () <block> end");
		if(tokens.get(1) instanceof ValueCoupling && ((ValueCoupling) tokens.get(1)).token.getType() == TokenType.IDENTIFIER){
			((ValueCoupling) tokens.get(1)).printGrammar();
		}
		for(int i = 4; i < tokens.size(); i++) {
			if((i != tokens.size() - 1) && (tokens.get(i + 1) instanceof IfCoupling || tokens.get(i + 1) instanceof AssignmentCoupling 
					|| tokens.get(i + 1) instanceof ForCoupling || tokens.get(i + 1) instanceof WhileCoupling 
					|| tokens.get(i + 1) instanceof PrintCoupling)) {
				System.out.println("<block> -> <statement> <block>");
				if(tokens.get(i) instanceof IfCoupling) {
					System.out.println("<statement> -> <if_statement>");
					((IfCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof ForCoupling) {
					System.out.println("<statement> -> <for_statement>");
					((ForCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof WhileCoupling) {
					System.out.println("<statement> -> <while_statement>");
					((WhileCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof AssignmentCoupling) {
					System.out.println("<statement> -> <assignment_statement>");
					((AssignmentCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof PrintCoupling) {
					System.out.println("<statement> -> <print_statement>");
					((PrintCoupling) tokens.get(i)).printGrammar();
				}
			}
			else {
				System.out.println("<block> -> <statement>");
				if(tokens.get(i) instanceof IfCoupling) {
					System.out.println("<statement> -> <if_statement>");
					((IfCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof ForCoupling) {
					System.out.println("<statement> -> <for_statement>");
					((ForCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof WhileCoupling) {
					System.out.println("<statement> -> <while_statement>");
					((WhileCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof AssignmentCoupling) {
					System.out.println("<statement> -> <assignment_statement>");
					((AssignmentCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof PrintCoupling) {
					System.out.println("<statement> -> <print_statement>");
					((PrintCoupling) tokens.get(i)).printGrammar();
				}
				System.out.println("end -> end\n");
				break;
			}
		}
	}
	
	public void controlStatementPrintGrammar() { // For printing the grammar of the block of the control statements
		for(int i = 0; i < tokens.size(); i++) {
			if((i != tokens.size() - 1) && (tokens.get(i + 1) instanceof IfCoupling || tokens.get(i + 1) instanceof AssignmentCoupling 
					|| tokens.get(i + 1) instanceof ForCoupling || tokens.get(i + 1) instanceof WhileCoupling 
					|| tokens.get(i + 1) instanceof PrintCoupling)) {
				System.out.println("<block> -> <statement> <block>");
				if(tokens.get(i) instanceof IfCoupling) {
					System.out.println("<statement> -> <if_statement>");
					((IfCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof ForCoupling) {
					System.out.println("<statement> -> <for_statement>");
					((ForCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof WhileCoupling) {
					System.out.println("<statement> -> <while_statement>");
					((WhileCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof AssignmentCoupling) {
					System.out.println("<statement> -> <assignment_statement>");
					((AssignmentCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof PrintCoupling) {
					System.out.println("<statement> -> <print_statement>");
					((PrintCoupling) tokens.get(i)).printGrammar();
				}
			}
			else {
				System.out.println("<block> -> <statement>");
				if(tokens.get(i) instanceof IfCoupling) {
					System.out.println("<statement> -> <if_statement>");
					((IfCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof ForCoupling) {
					System.out.println("<statement> -> <for_statement>");
					((ForCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof WhileCoupling) {
					System.out.println("<statement> -> <while_statement>");
					((WhileCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof AssignmentCoupling) {
					System.out.println("<statement> -> <assignment_statement>");
					((AssignmentCoupling) tokens.get(i)).printGrammar();
				}
				else if(tokens.get(i) instanceof PrintCoupling) {
					System.out.println("<statement> -> <print_statement>");
					((PrintCoupling) tokens.get(i)).printGrammar();
				}
				break;
			}
		}
	}
	
	public void interpret() {
		for(int i = 4; i < tokens.size(); i++) {
			if((i != tokens.size() - 1) && (tokens.get(i + 1) instanceof AssignmentCoupling || tokens.get(i + 1) instanceof PrintCoupling)) {
				if(tokens.get(i) instanceof AssignmentCoupling) {
					IT.addIdentifier(((AssignmentCoupling) tokens.get(i)).interpret());
				}
				else if(tokens.get(i) instanceof PrintCoupling) {
					((PrintCoupling) tokens.get(i)).interpret();
				}
			}
			else {
				if(tokens.get(i) instanceof AssignmentCoupling) {
					((AssignmentCoupling) tokens.get(i)).interpret();
				}
				else if(tokens.get(i) instanceof PrintCoupling) {
					((PrintCoupling) tokens.get(i)).interpret();
				break;
				}
			}
		}
	}
}
