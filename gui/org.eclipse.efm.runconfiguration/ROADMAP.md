# Symbolic Execution Workflow Run Configuration (Launcher)

Defining developments in short / medium / long term

## Short Term
Effectuer les tâches de migration définies dans [TODO.md](TODO.md)


## Medium Term

Develop a new intuitive and simple textual format for the SEW inspired by xtext workflow textual format

```java
@sew< version , 1.0 >:

Workflow "Symbolic Execution Workflow" {
	project {
		// Chemin absolu ou relatif (au dossier de lancement!) du projet DIVERSITY
		location = <path>
		// Chemin relatif à @project (ou absolu!) du dossier contenant les fichiers XFSP
		source = <path>
		// Chemin relatif à @project (ou absolu!) du dossier principal des fichiers générés par DIVERSITY
		output = <path>
		// Chemin relatif à @output (ou absolu!) du dossier des fichiers log et debug
		log = <path>
	}

	specification {
		main = <path>
	}

	fam "Formal Analysis Module" = hitorjump {
		// "Processor" de gestion des critères d'arrêt absolus (paramètres utilisateur)
		main {
			@property:

			log:

			debug {

			}

			queue {

			}
		}
	}

	moe = sequence /*parallel*/ {
		fam {

		}
		fam {

		}
	}
}
```

## Long Term
