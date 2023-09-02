package test.book;

import mixin.annotations.Method.AnnotationsMethod;
import mixin.annotations.Method.OverwriteMethod;
import mixin.annotations.Method.ReturnValueMethod;
import mixin.annotations.Mixin;
import mixin.annotations.field.AnnotationsField;

import java.lang.annotation.Annotation;
import java.util.Map;

import static mixin.Util.getAnnotation;

@Mixin(Book.class)
public class BookMixin {
    public static Book book = new Book("bookMixin", 2000, 101.1);

    @ReturnValueMethod("equals(Ljava/lang/Object;)Z")
    public static boolean equalsFalse(Book book, boolean returnValue, Object o) {
        return !returnValue;
    }

    @AnnotationsField("name")
    public static Annotation[] nameAnnotations() {
        return new Annotation[]{getAnnotation(Deprecated.class), getAnnotation(Deprecated.class, Map.ofEntries(Map.entry("since", "1")))};
    }

    @AnnotationsMethod("get()Ltest/book/mixin.annotations.Book;")
    public static Annotation[] getAnnotations() {
        return new Annotation[]{getAnnotation(Deprecated.class), getAnnotation(Deprecated.class, Map.ofEntries(Map.entry("since", "1")))};
    }

    @OverwriteMethod("get()Ltest/book/mixin.annotations.Book;")
    public static Book get(Book book1) {
        return book;
    }
}
