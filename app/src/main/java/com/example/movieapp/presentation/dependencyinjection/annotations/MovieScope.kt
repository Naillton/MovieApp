package com.example.movieapp.presentation.dependencyinjection.annotations

import javax.inject.Scope
import kotlin.annotation.Retention

/**
 * Criando anotacao para Movie, classes com o @Scope identificam anotacoes de escopo aplicando a
 * classe com construtor injetavel e controlando como o injetor reutiliza as instancias.
 * O @Retention determina se a anotacao é armazenada em uma saida binaria e visivel, por default
 * o RUNTIME define a Rettention como armazenada e visivel
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MovieScope()
