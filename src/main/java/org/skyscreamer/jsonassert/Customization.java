package org.skyscreamer.jsonassert;

import com.nebhale.jsonpath.JsonPath;
import org.hamcrest.Matcher;

public final class Customization {
	private final JsonPath path;
	private final EqualsComparator<Object> comparator;

	public Customization(JsonPath path, EqualsComparator<Object> comparator) {
        assert path != null;
        assert comparator != null;
		this.path = path;
		this.comparator = comparator;
	}

	public static Customization customization(String path, EqualsComparator<Object> comparator) {
		return customization(JsonPath.compile(path), comparator);
	}

    public static Customization customization(JsonPath path, EqualsComparator<Object> comparator) {
        return new Customization(path, comparator);
    }

//    public boolean appliesToPath(JsonPath path) {
//        return this.path.equals(path);
//        return this.path.
//    }

    public boolean matches(Object actual, Object expected) {
        return comparator.equal(actual, expected);
    }

    public JsonPath getPath() {
        return path;
    }
}
