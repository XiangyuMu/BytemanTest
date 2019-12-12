import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.ipa.callgraph.AnalysisScope;
import com.ibm.wala.ipa.cha.ClassHierarchy;
import com.ibm.wala.ipa.cha.ClassHierarchyException;
import com.ibm.wala.ipa.cha.ClassHierarchyFactory;
import com.ibm.wala.shrikeCT.InvalidClassFileException;
import com.ibm.wala.util.CancelException;
import com.ibm.wala.util.config.AnalysisScopeReader;
import com.ibm.wala.util.io.FileProvider;

import java.io.File;
import java.io.IOException;

public class ClassNameAnalysis {
    public static void main(String args[]) throws IOException, ClassHierarchyException, IllegalArgumentException, InvalidClassFileException, CancelException {

    // ���һ���ļ�

    File exFile =
        new FileProvider()
            .getFile("E:\\eclipse-workspace\\WALA_Test\\Java60RegressionExclusions.txt");

    // ��������浽�ļ���

    AnalysisScope scope =
        AnalysisScopeReader.makeJavaBinaryAnalysisScope(
            "E:\\eclipse-workspace\\BytemanTest", exFile);

        // ����ClassHierarchy���൱�����һ���㼶�ṹ

         ClassHierarchy cha = ClassHierarchyFactory.make(scope);

        // ѭ������ÿһ����

         for(IClass klass : cha) {

        // ��ӡ����

            System.out.println("ClassName: "+klass.getName().toString());

         // �жϵ�ǰ���Ƿ���zookeeper��

         if(scope.isApplicationLoader(klass.getClassLoader())) {

         // ����zookeeper�е����ÿ����������������ӡ������

                for (IMethod m : klass.getAllMethods()) {
                    System.out.println("FunctionName: "+m.getName().toString());
                }
            }
        }

    }

}