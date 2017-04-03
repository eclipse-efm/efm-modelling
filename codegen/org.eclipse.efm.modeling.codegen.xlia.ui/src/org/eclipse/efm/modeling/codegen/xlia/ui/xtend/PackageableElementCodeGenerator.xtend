package org.eclipse.efm.modeling.codegen.xlia.ui.xtend

import org.eclipse.uml2.uml.PackageableElement

class PackageableElementCodeGenerator {
	static def generateCode(PackageableElement element) '''
		/************************************************************
		              Pkg< «element.name» > package header
		 ************************************************************/
		 «element.class.simpleName» «element.name» {

		 }
	'''
}