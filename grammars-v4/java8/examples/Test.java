public class Test {
            public static void main(String[] args) throws Exception {
            ANTLRInputStream input = new ANTLRInputStream(System.in);
            ExprTreeLexer lex = new ExprTreeLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            ExprTreeParser parser = new ExprTreeParser(tokens);
            ExprTreeParser.prog_return r = parser.prog();
            CommonTree tree = r.tree;
            CommonTreeNodeStream treeStream = new CommonTreeNodeStream(tree);
            ExprEval walker = new ExprEval(treeStream);
            try
            {
                walker.prog();
            }
            catch (RecognitionException e)
            {
                e.printStackTrace();
            }

        }
}
