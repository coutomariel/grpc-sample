package br.com.zupacademy

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Mariel")
        .setCpf("00151587899")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setCep("95780000")
            .setLogradouro("Rua das araras")
            .setComplemento("Sala 03")
            .build())
        .build()

    print(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))
    request2.setCargo(Cargo.GERENTE)

    print(request2)
}