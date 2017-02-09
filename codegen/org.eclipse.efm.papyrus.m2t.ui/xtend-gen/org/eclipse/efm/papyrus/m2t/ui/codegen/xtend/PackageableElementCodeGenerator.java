package org.eclipse.efm.papyrus.m2t.ui.codegen.xtend;

import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PackageableElementCodeGenerator {
  public static CharSequence generateCode(final PackageableElement element) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/************************************************************");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("Pkg< ");
    String _name = element.getName();
    _builder.append(_name, "              ");
    _builder.append(" > package header");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("************************************************************/");
    _builder.newLine();
    _builder.append(" ");
    Class<? extends PackageableElement> _class = element.getClass();
    String _simpleName = _class.getSimpleName();
    _builder.append(_simpleName, " ");
    _builder.append(" ");
    String _name_1 = element.getName();
    _builder.append(_name_1, " ");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
