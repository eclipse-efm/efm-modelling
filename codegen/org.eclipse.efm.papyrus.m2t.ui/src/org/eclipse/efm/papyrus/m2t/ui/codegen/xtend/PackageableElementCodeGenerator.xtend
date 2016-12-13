package org.eclipse.efm.papyrus.m2t.ui.codegen.xtend

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