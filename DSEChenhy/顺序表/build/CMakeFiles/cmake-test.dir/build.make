# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\CMake\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\CMake\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "D:\Desktop\homework OfSophomore\DataSHomework\week1"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "D:\Desktop\homework OfSophomore\DataSHomework\week1\build"

# Include any dependencies generated for this target.
include CMakeFiles/cmake-test.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/cmake-test.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/cmake-test.dir/flags.make

CMakeFiles/cmake-test.dir/Src/main.cpp.obj: CMakeFiles/cmake-test.dir/flags.make
CMakeFiles/cmake-test.dir/Src/main.cpp.obj: CMakeFiles/cmake-test.dir/includes_CXX.rsp
CMakeFiles/cmake-test.dir/Src/main.cpp.obj: ../Src/main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="D:\Desktop\homework OfSophomore\DataSHomework\week1\build\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/cmake-test.dir/Src/main.cpp.obj"
	C:\mingw64\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\cmake-test.dir\Src\main.cpp.obj -c "D:\Desktop\homework OfSophomore\DataSHomework\week1\Src\main.cpp"

CMakeFiles/cmake-test.dir/Src/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/cmake-test.dir/Src/main.cpp.i"
	C:\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "D:\Desktop\homework OfSophomore\DataSHomework\week1\Src\main.cpp" > CMakeFiles\cmake-test.dir\Src\main.cpp.i

CMakeFiles/cmake-test.dir/Src/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/cmake-test.dir/Src/main.cpp.s"
	C:\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "D:\Desktop\homework OfSophomore\DataSHomework\week1\Src\main.cpp" -o CMakeFiles\cmake-test.dir\Src\main.cpp.s

CMakeFiles/cmake-test.dir/Src/studUnit.cpp.obj: CMakeFiles/cmake-test.dir/flags.make
CMakeFiles/cmake-test.dir/Src/studUnit.cpp.obj: CMakeFiles/cmake-test.dir/includes_CXX.rsp
CMakeFiles/cmake-test.dir/Src/studUnit.cpp.obj: ../Src/studUnit.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="D:\Desktop\homework OfSophomore\DataSHomework\week1\build\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/cmake-test.dir/Src/studUnit.cpp.obj"
	C:\mingw64\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\cmake-test.dir\Src\studUnit.cpp.obj -c "D:\Desktop\homework OfSophomore\DataSHomework\week1\Src\studUnit.cpp"

CMakeFiles/cmake-test.dir/Src/studUnit.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/cmake-test.dir/Src/studUnit.cpp.i"
	C:\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "D:\Desktop\homework OfSophomore\DataSHomework\week1\Src\studUnit.cpp" > CMakeFiles\cmake-test.dir\Src\studUnit.cpp.i

CMakeFiles/cmake-test.dir/Src/studUnit.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/cmake-test.dir/Src/studUnit.cpp.s"
	C:\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "D:\Desktop\homework OfSophomore\DataSHomework\week1\Src\studUnit.cpp" -o CMakeFiles\cmake-test.dir\Src\studUnit.cpp.s

# Object files for target cmake-test
cmake__test_OBJECTS = \
"CMakeFiles/cmake-test.dir/Src/main.cpp.obj" \
"CMakeFiles/cmake-test.dir/Src/studUnit.cpp.obj"

# External object files for target cmake-test
cmake__test_EXTERNAL_OBJECTS =

bin/cmake-test.exe: CMakeFiles/cmake-test.dir/Src/main.cpp.obj
bin/cmake-test.exe: CMakeFiles/cmake-test.dir/Src/studUnit.cpp.obj
bin/cmake-test.exe: CMakeFiles/cmake-test.dir/build.make
bin/cmake-test.exe: CMakeFiles/cmake-test.dir/linklibs.rsp
bin/cmake-test.exe: CMakeFiles/cmake-test.dir/objects1.rsp
bin/cmake-test.exe: CMakeFiles/cmake-test.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="D:\Desktop\homework OfSophomore\DataSHomework\week1\build\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable bin\cmake-test.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\cmake-test.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/cmake-test.dir/build: bin/cmake-test.exe

.PHONY : CMakeFiles/cmake-test.dir/build

CMakeFiles/cmake-test.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\cmake-test.dir\cmake_clean.cmake
.PHONY : CMakeFiles/cmake-test.dir/clean

CMakeFiles/cmake-test.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "D:\Desktop\homework OfSophomore\DataSHomework\week1" "D:\Desktop\homework OfSophomore\DataSHomework\week1" "D:\Desktop\homework OfSophomore\DataSHomework\week1\build" "D:\Desktop\homework OfSophomore\DataSHomework\week1\build" "D:\Desktop\homework OfSophomore\DataSHomework\week1\build\CMakeFiles\cmake-test.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/cmake-test.dir/depend

