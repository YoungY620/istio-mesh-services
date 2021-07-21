# 1: Build the exe
FROM rust:1.53.0-buster as builder
WORKDIR /usr/src

# 1a: Prepare for static linking
RUN apt-get update \
    && apt-get dist-upgrade -y \
    && apt-get install -y musl-tools 
    # && rustup target add x86_64-unknown-linux-musl

RUN apt-get install -y openssl

RUN apt-get install -y libssl-dev


# 1b: Download and compile Rust dependencies (and store as a separate Docker layer)
RUN USER=root cargo new myprogram
RUN apt-get install -y pkg-config
WORKDIR /usr/src/myprogram
COPY Cargo.toml  ./
RUN cargo install \
    # --target x86_64-unknown-linux-musl \
    --path .


# 1c: Build the exe using the actual source code
COPY src ./src
RUN cargo install \
    # --target x86_64-unknown-linux-musl \
    --path .

# 2: Copy the exe and extra files ("static") to an empty Docker image
FROM scratch
COPY --from=builder /usr/local/cargo/bin/myprogram .
COPY static .
USER 1000
CMD ["./myprogram"]