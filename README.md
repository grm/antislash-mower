# antislash-mower

[![Build Status](https://travis-ci.org/grm/antislash-mower.svg?branch=master)](https://travis-ci.org/grm/antislash-mower)
[![Maintainability](https://api.codeclimate.com/v1/badges/7e05c98c6ba538260db9/maintainability)](https://codeclimate.com/github/grm/antislash-mower/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/7e05c98c6ba538260db9/test_coverage)](https://codeclimate.com/github/grm/antislash-mower/test_coverage)

## Description

This project is a simple mower planner.
It uses a grid to represent a garden and mower can be placed on this grid.

## Get sources and Build

In order to build you should have maven installed.
```bash
$ git clone https://github.com/grm/antislash-mower
$ cd antislash-mower
$ mvn package
```

## Usage

First you need to create a config file in the form :
```
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```

Once the package is built, you can run it using :
```bash
$ java -jar target/mowitnow-0.1-jar-with-dependencies.jar -f /path/to/config/file
```