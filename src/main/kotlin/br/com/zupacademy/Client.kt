package br.com.zupacademy

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    var request = FuncionarioRequest.newBuilder()
        .setNome("Abrey")
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

    val response = client.cadastrar(request)
    print(response)

}