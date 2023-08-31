package com.joker.dorabey.processors;


//import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.auto.service.AutoService;
//import com.joker.dorabey.annotations.FromEntity;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
//import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
//import javax.lang.model.type.MirroredTypeException;
//import javax.lang.model.type.TypeMirror;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import java.io.IOException;
//import java.lang.reflect.Method;
import java.nio.charset.Charset;
//import java.util.Objects;
import java.util.Set;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreeScanner;
import com.sun.tools.javac.api.JavacTool;
import com.sun.tools.javac.file.JavacFileManager;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.util.Context;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@SupportedAnnotationTypes({"com.joker.dorabey.annotations.FromEntity"})
@SupportedSourceVersion(SourceVersion.RELEASE_11)
@AutoService(Processor.class)
public class FromEntityProcessor extends AbstractProcessor {

    private JavacFileManager fileManager = new JavacFileManager(new Context(), true, Charset.defaultCharset());;
    private JavacTool javacTool = JavacTool.create();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
//        System.out.println(">>>>> INIT START <<<<<");
//        this.messager = processingEnv.getMessager();
//        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
//        this.treeMaker = TreeMaker.instance(context);
//        this.names = Names.instance(context);
//
//        System.out.println(">>>>> INIT END <<<<<");
    }

    @Override
    public boolean process(Set<? extends TypeElement> elements, RoundEnvironment env) {
//        System.out.println(">>>>> processing:");
//        if (elements == null || elements.isEmpty()) {
//            System.out.println(">>>>> elements is empty.");
//            return false;
//        }
//        for (Element e: env.getElementsAnnotatedWith(FromEntity.class)) {
//            FromEntity fromEntity = e.getAnnotation(FromEntity.class);
//            String mappings = fromEntity.mappings();
//            TypeMirror typeMirror = null;
//            try {
//                Class t = fromEntity.clazz();
//            } catch( MirroredTypeException mte ) {
//                typeMirror = mte.getTypeMirror();
//            }
//            System.out.println(">>>>> mapping = " + mappings + ", type mirror = " + (Objects.isNull(typeMirror) ? "null" : typeMirror.toString()));
//
//            // TODO
//            // 到上面位置，我取到了使用FromEntity注解的类，以及mappings和clazz两个参数
//            // 接下来要弄得是，怎么获取当前类和clazz对应的类的字段
//            // (Class.forName这时是用不了的，因为这时在编译，还没有class，所以可能需要去读java文件)
//            // (参考：http://ragnraok.github.io/using-jdk-parser.html)
//            // 之后就是怎么把我想要的构造函数给塞进去了。
//
//            try {
//                // 根据给定的类名初始化类
//                Class catClass = Class.forName(typeMirror.toString());
//                // 实例化这个类
//                Object obj = catClass.newInstance();
//                // 获得这个类的所有方法
//                Method[] methods = catClass.getMethods();
//                // 循环查找想要的方法
//                for(Method method : methods) {
//                    System.out.println(">>>>> method = " + method.getName());
//                }
//            } catch (ClassNotFoundException exp) {
//                exp.printStackTrace();
//            } catch (InstantiationException exp) {
//                exp.printStackTrace();
//            } catch (IllegalAccessException exp) {
//                exp.printStackTrace();
//            }
//        }
        return true;
    }

//    public void parseJavaFiles() {
//        Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjects(path);
//        JavaCompiler.CompilationTask compilationTask = javacTool.getTask(null, fileManager, null, null, null, files);
//        JavacTask javacTask = (JavacTask) compilationTask
//        try {
//            Iterable<? extends CompilationUnitTree> result = javacTask.parse();
//            for (CompilationUnitTree tree : result) {
//                tree.accept(new SourceVisitor(), null);
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static class SourceVisitor extends TreeScanner<Void, Void> {

        private String currentPackageName = null;

        @Override
        public Void visitCompilationUnit(CompilationUnitTree node, Void aVoid) {
            return super.visitCompilationUnit(node, aVoid);
        }

        @Override
        public Void visitVariable(VariableTree node, Void aVoid) {
            formatPtrln("variable name: %s, type: %s, kind: %s, package: %s",
                    node.getName(), node.getType(), node.getKind(), currentPackageName);
            return null;
        }
    }

    public static void formatPtrln(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

}
