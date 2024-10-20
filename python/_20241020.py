"""
1106. Parsing A Boolean Expression
"""


class Solution(object):
    def parse_or(self, expression):
        if "," in expression:
            curr = ""
            open_bracket_count = 0
            for c in expression:
                if open_bracket_count == 0 and c == ",":
                    if self.parseBoolExpr(curr):
                        return True
                    curr = ""
                    continue
                elif c == "(":
                    open_bracket_count += 1
                elif c == ")":
                    open_bracket_count -= 1
                curr = curr + c
            return self.parseBoolExpr(curr)
        return self.parseBoolExpr(expression)

    def parse_and(self, expression):
        if "," in expression:
            curr = ""
            open_bracket_count = 0
            for c in expression:
                if open_bracket_count == 0 and c == ",":
                    if not self.parseBoolExpr(curr):
                        return False
                    curr = ""
                    continue
                elif c == "(":
                    open_bracket_count += 1
                elif c == ")":
                    open_bracket_count -= 1
                curr = curr + c
            return self.parseBoolExpr(curr)
        return self.parseBoolExpr(expression)

    def parse_not(self, expression):
        boolMap = {
            "t": True,
            "f": False
        }
        if len(expression) == 1:
            return not boolMap[expression]

        return not self.parseBoolExpr(expression)

    def parseBoolExpr(self, expression):
        """
        :type expression: str
        :rtype: bool
        """
        if expression == "f":
            return False

        elif expression == "t":
            return True

        elif expression[0] == "!":
            return self.parse_not(expression[2:-1])

        elif expression[0] == "&":
            return True and self.parse_and(expression[2:-1])

        else:
            return self.parse_or(expression[2:-1])


solver = Solution()

res = solver.parseBoolExpr("!(&(!(&(f)),&(t),|(f,f,t)))")
print(res)

# tests = [
#     ["|(&(t,f,t),t)", True],
#     ["&(!(f),t)", True],
#     ["|(f,f,f,t)", True],
#     ["!(&(f,t))", True],
#     ["|(!(f))", True]
# ]
#
# for test in tests:
#     expression_test, result = test
#     assert solver.parseBoolExpr(expression_test) == result, f"{expression_test} should be {result}"
