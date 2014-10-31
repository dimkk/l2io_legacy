/*
 * Copyright (c) 2014 acmi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package acmi.l2.clientmod.unreal.Core;

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.properties.PropertiesUtil;

import java.io.IOException;
import java.util.Map;

public class DelegateProperty extends Property {
    public final int event;

    public DelegateProperty(DataInput input, UnrealPackageReadOnly.ExportEntry entry, PropertiesUtil propertiesUtil) throws IOException {
        super(input, entry, propertiesUtil);

        event = input.readCompactInt();
    }

    public UnrealPackageReadOnly.Entry getEvent() {
        return getEntry().getUnrealPackage().objectReference(event);
    }

    @Override
    public Map<String, String> getInfo() {
        Map<String, String> props = super.getInfo();
        props.put("event", getEvent().toString());
        return props;
    }
}