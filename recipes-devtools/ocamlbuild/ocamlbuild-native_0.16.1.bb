SUMMARY = "OCamlbuild is a generic build tool, that has built-in rules for building OCaml library and programs."
HOMEPAGE = "https://github.com/ocaml/ocamlbuild"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5123b1988300c0d24c79e04f09d86dc0"

# Packages supported
# ocamlbuild-native : Package built on build machine.
inherit native

# Packages required to build.
DEPENDS = "ocaml-native"

# Parallel make does not work with some recipes
PARALLEL_MAKE = ""
PARALLEL_MAKEINST = ""

# Source repo
SRC_URI += " \
    git://github.com/ocaml/ocamlbuild;protocol=https;branch=master \
    file://0001-makefile-change-include-path.patch \
"

PV = "0.16.1"
SRCREV = "131ba63a1b96d00f3986c8187677c8af61d20a08"

# S = "${WORKDIR}/ocamlbuild-0.14.0"



do_configure () {
    oe_runmake OCAMLBUILD_BINDIR="${bindir}" configure
}

do_compile () {
    oe_runmake OCAMLLIB="${libdir}/ocaml"
}

do_install () {
    oe_runmake DESTDIR="${D}" install
}
